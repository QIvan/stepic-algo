plugins {
    kotlin("jvm") version "1.3.72"

}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(group = "junit", name = "junit", version = "4.12")
}

repositories {
    jcenter()
}
