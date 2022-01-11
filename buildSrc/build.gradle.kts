plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.6.10")
    implementation(kotlin("gradle-plugin", "1.6.10"))
}