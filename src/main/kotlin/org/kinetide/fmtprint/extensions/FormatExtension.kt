package org.kinetide.fmtprint.extensions

import org.kinetide.fmtprint.FormatPrinter

fun Any.formatPrintln() = FormatPrinter.println(this)