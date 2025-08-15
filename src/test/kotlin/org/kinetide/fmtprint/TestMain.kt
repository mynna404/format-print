package org.kinetide.fmtprint

import org.kinetide.fmtprint.entity.School
import org.kinetide.fmtprint.entity.Student
import org.kinetide.fmtprint.extensions.formatPrintln
import org.kinetide.fmtprint.utils.JsonUtil
import kotlin.test.Test

class FormatPrintTest {

    @Test
    fun testObject() {
        val student = Student("Kinetide", 18, "Male", intArrayOf(121, 205, 303))
        // 测试扩展函数
        student.formatPrintln()
        Format.println(student)
    }

    @Test
    fun testNestedObject() {
        val school = School(
            name = "Kinetide",
            address = "Shanghai",
            students = listOf(
                Student("Mynna404", 18, "Male", intArrayOf(121, 205, 303)),
                Student("Mynna405", 19, "Male", intArrayOf(121, 205, 303)),
                Student("Mynna500", 20, "Female", intArrayOf(121, 205, 303))
            )
        )
        Format.println(school)
    }

    @Test
    fun testJson() {
        val user = Student("Kinetide", 12, "male", intArrayOf(121, 205, 303))
        val json = JsonUtil.toJson(user)
        println(json)
        Format.println(json)
    }

    @Test
    fun testList() {
        val list = listOf(
            Student("Mynna404", 18, "Male", intArrayOf(121, 205, 303)),
            Student("Mynna405", 19, "Male", intArrayOf(121, 205, 303)),
            Student("Mynna500", 20, "Female", intArrayOf(121, 205, 303))
        )
        Format.println(list)
    }

    @Test
    fun testMap() {
        val map = mapOf(
            "Mynna404" to Student("Mynna404", 18, "Male", intArrayOf(121, 205, 303)),
            "Mynna405" to Student("Mynna405", 19, "Male", intArrayOf(121, 205, 303)),
            "Mynna500" to Student("Mynna500", 20, "Female", intArrayOf(121, 205, 303))
        )
        Format.println(map)
    }

    @Test
    fun testSet() {
        val set = setOf(
            Student("Mynna404", 18, "Male", intArrayOf(121, 205, 303)),
            Student("Mynna405", 19, "Male", intArrayOf(121, 205, 303)),
            Student("Mynna500", 20, "Female", intArrayOf(121, 205, 303))
        )
        Format.println(set)
    }

    @Test
    fun testString() {
        val str = "Kinetide"
        Format.println(str)
    }

}