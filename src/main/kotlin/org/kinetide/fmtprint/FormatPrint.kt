package org.kinetide.fmtprint

import org.kinetide.fmtprint.extensions.toJson

object Format {
    private const val INDENT = "    "

    fun println(obj: Any?) {
        if (obj == null) {
            kotlin.io.println()
            return
        }
        val className = obj.javaClass.simpleName
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

        for (char in jsonStr) {
            when (char) {
                '{', '[' -> {
                    result.append(char).append('\n')
                    result.append(INDENT.repeat(++indentLevel))
                }

                '}', ']' -> {
                    result.trimTrailingSpaces()
                    result.append('\n').append(INDENT.repeat(--indentLevel)).append(char)
                }

                ',' -> {
                    result.append(",\n").append(INDENT.repeat(indentLevel))
                }

                ':' -> {
                    result.append(" = ")
                }

                ' ' -> {
                    if (result.shouldKeepSpace()) {
                        result.append(char)
                    }
                }

                '\n', '\r' -> {
                    // 忽略原有换行符
                }

                else -> {
                    result.append(char)
                }
            }
        }

        return result.toString()
    }

    private fun StringBuilder.trimTrailingSpaces() {
        while (isNotEmpty() && last() == ' ') {
            deleteCharAt(length - 1)
        }
    }

    private fun StringBuilder.shouldKeepSpace(): Boolean {
        return isNotEmpty() && last() != ' '
    }
}