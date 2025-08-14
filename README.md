# 🌿 format-print

fmt-print 是一个为 Java 和 Kotlin 开发者设计的小型实用库，旨在提供更加友好、结构化的对象内容打印方式。相比默认的 `toString()` 输出常常是一整行难以阅读的信息，或者是一段密密麻麻的 JSON 字符串，fmt-print 可以打印出对象内容更直观、层次更清晰、便于阅读和调试的对象信息。

无论是嵌套的对象、集合、Map、JSON 字符串，还是自定义的类结构，fmt-print 都能以更加人性化的方式呈现出来。它特别适合在调试阶段快速了解对象的真实结构与内容，而无需手动格式化输出或依赖重量级工具。

该库零配置使用，可完全替代原本的`System.out.println()`与Kotlin的`println()`


## 🚀 快速上手

### 1. 引入依赖

Gradle (Kotlin DSL)  
```kotlin
暂未提供
```

Maven  
```xml
暂未提供
```

### 2. 一行代码打印

```kotlin
data class Student(val name: String, val age: Int, val sex: String)
data class School(val name: String, val address: String, val students: List<Student>)

fun main() {
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
```

### 3. 输出示例

```
School@2c81ba77 {
    "name" = "Kinetide",
    "address" = "Shanghai",
    "students" = [
        {
            "name" = "Mynna404",
            "age" = 18,
            "sex" = "Male"
        },
        {
            "name" = "Mynna405",
            "age" = 19,
            "sex" = "Male"
        },
        {
            "name" = "Mynna500",
            "age" = 20,
            "sex" = "Female"
        }
    ]
}
```

- 第一行显示 **类名 + 十六进制对象地址**，便于调试时快速定位实例。  
- 字段名与值使用 `=` 对齐，键名保留双引号，保持 JSON 语义。  
- 自动递归展开嵌套对象、集合、Map，缩进 4 空格，层次一目了然。

---

## 🛠️ 用法
其用法与System.out.println() 完全一致

| 功能 | 示例 |
|---|---|
| 打印任意对象 | `println(myObject)` |
| 打印 Map / List | `println(mapOf("a" to 1, "b" to 2))` |
| 打印 JSON 字符串 | `println("""{"x":1,"y":{"z":2}}""")` |
| Java 项目 | 同样适用：`Format.println(obj);` |

 
