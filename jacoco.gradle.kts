@file:Suppress("UnstableApiUsage")

tasks.withType<JacocoReport> {
    dependsOn.add("testDebugUnitTest")
    dependsOn.add("createDebugCoverageReport")



    reports {
        html.isEnabled = true
        xml.isEnabled = false
    }

    val fileFilter = listOf(
        "**/R.class",
        "**/R$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "android/**/*.*"
    )
    val debugTree = fileTree("${buildDir}/intermediates/classes/debug") {
        fileFilter.forEach { excludes.add(it) }
    }
    val mainSrc = "${project.projectDir}/src/main/java"

    sourceDirectories.setFrom(mainSrc)
    classDirectories.setFrom(debugTree.builtBy)
    executionData.setFrom(fileTree("$buildDir") {
        includes.add("**/*.exec")
        includes.add("**/*.ec")
    }.builtBy)
}

