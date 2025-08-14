package org.kinetide.fmtprint.extensions

import org.kinetide.fmtprint.utils.JsonUtil


fun Any.toJson(): String = JsonUtil.toJson(this)

fun String.isJson(): Boolean = isNotBlank() &&
        ((startsWith("{") && endsWith("}")) ||
                (startsWith("[") && endsWith("]")))