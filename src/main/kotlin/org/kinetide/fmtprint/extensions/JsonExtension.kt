package org.kinetide.fmtprint.org.kinetide.fmtprint.extensions

import org.kinetide.fmtprint.org.kinetide.fmtprint.utils.JsonUtil


fun Any.toJson(): String = JsonUtil.toJson(this)