plugins {
    id("tech.medivh.plugin.publisher") version "1.2.5"
    kotlin("jvm") version "2.2.0"
}

group = "io.github.mynna404"
version = "0.0.2-beta4"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

medivhPublisher{
    groupId = project.group.toString()
    artifactId = project.name
    version = project.version.toString()
    pom{
        name = "format-print"
        description = "format-print is a tool designed to provide Java and Kotlin developers with a more user-friendly and structured way to print object contents."
        url = "https://github.com/mynna404/format-print"
        licenses{
            license{
                name = "Apache-2.0 license"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "mynna404"
                name = "mynna404"
                email = "gemingjia0201@163.com"
            }
        }
        scm {
            connection = "scm:git:"
            url = "https://github.com/mynna404/format-print"
        }
    }
}