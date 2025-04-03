plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "me.sterling"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

application {
    mainClass.set("MainKt")
}
