import io.gitlab.arturbosch.detekt.detekt

buildscript {
    Dependencies.addRepos(repositories)

    dependencies {
        classpath(Dependencies.Gradle.android)
        classpath(Dependencies.Gradle.kotlin)
        classpath(Dependencies.Gradle.detekt)
        classpath(Dependencies.Gradle.safeArgs)
    }
}

allprojects {
    Dependencies.addRepos(repositories)

    apply {
        plugin("io.gitlab.arturbosch.detekt")
    }

    detekt {
        toolVersion = Version.Implementation.detekt
        config = files("$rootDir/detekt_config.yml")

        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt.html")
            }
            txt {
                enabled = false
            }
            xml {
                enabled = false
            }
        }
    }


//    apply("$rootDir/detekt.gradle.kts")
    apply("$rootDir/jacoco.gradle.kts")
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

plugins {
    jacoco
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    setExcludes(listOf(".*build.*", ".*/resources/.*", ".*/tmp/.*"))
}

