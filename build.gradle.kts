import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.dokka") version ("1.6.10")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        named("main") {
            moduleName.set("Dokka Gradle Example")
            includes.from("Module.md")
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/chkpnt/dokka-gradle-example/tree/master/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
        }
    }
}

tasks.register("printSourceSetInformation") {
    doLast {
        sourceSets.forEach { srcSet ->
            println("[${srcSet.name}]")
            println("-->Source directories: ${srcSet.allJava.srcDirs}")
            println("-->Output directories: ${srcSet.output.classesDirs.files}")
            println("")
        }
    }
}
