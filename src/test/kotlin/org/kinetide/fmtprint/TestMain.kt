package org.kinetide.fmtprint

import org.kinetide.fmtprint.entity.School
import org.kinetide.fmtprint.entity.Student
import org.kinetide.fmtprint.utils.JsonUtil
import kotlin.test.Test

class FormatPrintTest {

    @Test
    fun testObject() {
        val student = Student("Kinetide", 18, "Male")
        Format.println(student)
    }

    @Test
    fun testNestedObject() {
        val school = School(
            name = "Kinetide",
            address = "Shanghai",
            students = listOf(
                Student("Mynna404", 18, "Male"),
                Student("Mynna405", 19, "Male"),
                Student("Mynna500", 20, "Female")
            )
        )
        Format.println(school)
    }

    @Test
    fun testJson() {
        val user = Student("Kinetide", 12, "male")
        val json = JsonUtil.toJson(user)
        Format.println(json)
    }

    @Test
    fun testList() {
        val list = listOf(
            Student("Mynna404", 18, "Male"),
            Student("Mynna405", 19, "Male"),
            Student("Mynna500", 20, "Female")
        )
        Format.println(list)
    }

    @Test
    fun testMap() {
        val map = mapOf(
            "Mynna404" to Student("Mynna404", 18, "Male"),
            "Mynna405" to Student("Mynna405", 19, "Male"),
            "Mynna500" to Student("Mynna500", 20, "Female")
        )
        Format.println(map)
    }

    @Test
    fun testSet() {
        val set = setOf(
            Student("Mynna404", 18, "Male"),
            Student("Mynna405", 19, "Male"),
            Student("Mynna500", 20, "Female")
        )
        Format.println(set)
    }

}