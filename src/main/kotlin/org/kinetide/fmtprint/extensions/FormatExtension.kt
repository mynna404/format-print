package org.kinetide.fmtprint.extensions

import org.kinetide.fmtprint.Format

fun Any.formatPrintln() = Format.println(this)