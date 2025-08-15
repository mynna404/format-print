package org.kinetide.fmtprint

object Fmt {

    fun println(obj: Any?) {
        FormatPrinter.println(obj)
    }

}

val fmt = Fmt