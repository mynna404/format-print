package org.kinetide.fmtprint.entity

data class Student(
    val name: String,
    val age: Int,
    val sex: String,
    val classRoom: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (age != other.age) return false
        if (name != other.name) return false
        if (sex != other.sex) return false
        if (!classRoom.contentEquals(other.classRoom)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = age
        result = 31 * result + name.hashCode()
        result = 31 * result + sex.hashCode()
        result = 31 * result + classRoom.contentHashCode()
        return result
    }
}