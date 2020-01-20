plugins {
    id(BuildPlugin.androidApplication)
    id(BuildPlugin.kotlinAndroid)
    id(BuildPlugin.kotlinAndroidExtensions)
    kotlin(BuildPlugin.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.tools)
    defaultConfig {
        applicationId = BuildPlugin.applicationId
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)

        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = BuildPlugin.testInstrumentationRunner
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
            isTestCoverageEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }


    sourceSets {
        getByName("androidTest") {
            java.srcDirs("src/sharedTest/java")
        }
        getByName("test") {
            java.srcDirs("src/sharedTest/java")
        }
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
        execution = "ANDROID_TEST_ORCHESTRATOR"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":network"))
    implementation(project(":data"))

    //Android
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.ktxCore)
    implementation(Dependencies.AndroidX.lifecycleExt)
    implementation(Dependencies.AndroidX.viewModelKtx)
    implementation(Dependencies.AndroidX.navigationFragment)
    implementation(Dependencies.AndroidX.navigationUi)

    //Dagger
    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    //Detekt
    detektPlugins(Dependencies.Detekt.formatting)
    implementation(Dependencies.Kotlin.core)

    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //Square
    implementation(Dependencies.Square.retrofit)


    //Test)
    debugImplementation(Dependencies.Test.fragment) {
        exclude("androidx.test", "monitor")
        exclude("androidx.test", "core")
    }

    testImplementation(Dependencies.Test.androidxCore)
    testImplementation(Dependencies.Test.androidxCoreArch)
    testImplementation(Dependencies.Test.androidxRunner)
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockk)

    // AndroidTest)
    androidTestImplementation(Dependencies.Test.androidxCore)
    androidTestImplementation(Dependencies.Test.androidxCoreArch)
    androidTestImplementation(Dependencies.Test.androidxJunit)
    androidTestImplementation(Dependencies.Test.androidxRunner)
    androidTestImplementation(Dependencies.Test.androidxRules)
    androidTestImplementation(Dependencies.Test.espressoCore)
    androidTestImplementation(Dependencies.Test.junitKtx)
    androidTestImplementation(Dependencies.Test.mockkAndroid) {
        exclude(module = "objenesis")
    }
    androidTestImplementation(Dependencies.Test.objenesis)

}

tasks {
    getByName("preBuild") {
        dependsOn("detekt")
    }
}
