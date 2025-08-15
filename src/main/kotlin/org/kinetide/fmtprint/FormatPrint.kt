package org.kinetide.fmtprint

import org.kinetide.fmtprint.config.FormatPrintConfig
import org.kinetide.fmtprint.extensions.isJson
import org.kinetide.fmtprint.extensions.toJson

object Format {

    private const val ONE_INDENT = " "

    private fun indent(): String = ONE_INDENT.repeat(FormatPrintConfig.indentNumber)

    fun println(obj: Any?) {
        if (obj == null) {
            kotlin.io.println()
            return
        }

        val className = if (obj is String && obj.isJson()) "Json" else obj.javaClass.simpleName

        val objectAddress = getObjectAddress(obj)
        val jsonStr = obj.toJson()

        val formattedJson = formatJsonString(jsonStr)
        val result = "$className@$objectAddress $formattedJson"

        kotlin.io.println(result)
    }

    private fun getObjectAddress(obj: Any): String {
        return obj.hashCode().toUInt().toString(16)
    }

    private fun formatJsonString(jsonStr: String): String {
        val result = StringBuilder(jsonStr.length * 2)
        var indentLevel = 0
        var i = 0

        while (i < jsonStr.length) {
            when (val char = jsonStr[i]) {
                '[' -> {
                    // 预读，判断数组是不是简单类型（纯数字/字符，无嵌套）
                    val closingIndex = findClosingBracket(jsonStr, i, '[', ']')
                    if (closingIndex != -1) {
                        val arrayContent = jsonStr.substring(i, closingIndex + 1).trim()
                        if (isSimpleArray(arrayContent)) {
                            result.append(arrayContent.replace(",", ", "))
                            i = closingIndex
                        } else {
                            result.append('[').append('\n')
                            indentLevel++
                            result.append(indent().repeat(indentLevel))
                        }
                    } else {
                        result.append('[')
                    }
                }

                '{' -> {
                    result.append('{').append('\n')
                    indentLevel++
                    result.append(indent().repeat(indentLevel))
                }

                '}' -> {
                    result.trimTrailingSpaces()
                    result.append('\n').append(indent().repeat(--indentLevel)).append('}')
                }

                ']' -> {
                    result.trimTrailingSpaces()
                    result.append('\n').append(indent().repeat(--indentLevel)).append(']')
                }

                ',' -> {
                    result.append(",\n").append(indent().repeat(indentLevel))
                }

                ':' -> {
                    result.append(" = ")
                }

                ' ', '\n', '\r' -> {
                    // 忽略空格和原有换行
                }

                else -> {
                    result.append(char)
                }
            }
            i++
        }
        return result.toString()
    }

    private fun findClosingBracket(str: String, startIndex: Int, open: Char, close: Char): Int {
        var count = 0
        for (i in startIndex until str.length) {
            if (str[i] == open) count++
            if (str[i] == close) count--
            if (count == 0) return i
        }
        return -1
    }

    private fun isSimpleArray(arrayStr: String): Boolean {
        // 判断是否形如 [1,2,3] 或 ['a','b']
        val inner = arrayStr.removePrefix("[").removeSuffix("]").trim()
        if (inner.isEmpty()) return true
        return !inner.contains("{") && !inner.contains("[") && !inner.contains("\n")
    }


    private fun StringBuilder.trimTrailingSpaces() {
        while (isNotEmpty() && (last() == ' ' || last() == '\t')) {
            deleteCharAt(length - 1)
        }
    }

}