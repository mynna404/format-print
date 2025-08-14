package org.kinetide.fmtprint.entity

data class School(
    val name: String,
    val address: String,
    val students: List<Student>
)