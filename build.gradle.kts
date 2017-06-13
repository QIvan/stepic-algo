buildscript {

    val kotlin_version = "1.1.2-4"

    repositories {
        mavenCentral()
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        
    }

}

plugins {
}

apply {
    plugin("idea")
    plugin("kotlin")
}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib"))
    testCompile(group = "junit", name = "junit", version = "4.12")


}
