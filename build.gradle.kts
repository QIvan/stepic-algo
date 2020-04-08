plugins {
    kotlin("jvm") version "1.3.71"

}

dependencies {
    compile(kotlin("stdlib"))
    testCompile(group = "junit", name = "junit", version = "4.12")
}

repositories {
    jcenter()
}
