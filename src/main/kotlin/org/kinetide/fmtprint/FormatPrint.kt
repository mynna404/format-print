package org.kinetide.fmtprint

import org.kinetide.fmtprint.extensions.toJson

object Format {

    fun println(obj: Any) {
        kotlin.io.println(obj.toJson())
    }

}