import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.GradleDokkaSourceSetBuilder
import java.net.URL

plugins {
    id("org.jetbrains.dokka")
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

tasks.register("printSourceSetInformationFromPrecompiledScript") {
    doLast {
        project.the<SourceSetContainer>().forEach { srcSet ->
            println("[${srcSet.name}]")
            println("-->Source directories: ${srcSet.allJava.srcDirs}")
            println("-->Output directories: ${srcSet.output.classesDirs.files}")
            println("")
        }
    }
}
