package org.kinetide.fmtprint

import org.kinetide.fmtprint.entity.School
import org.kinetide.fmtprint.entity.User

fun main() {
    val user0 = User("Mynna404", 18, "Male")
    val user1 = User("Mynna405", 19, "Male")
    val user2 = User("Mynna500", 20, "Female")
    val school = School("Kinetide", "Shanghai", listOf(user0, user1, user2))
    Format.println(school)
}