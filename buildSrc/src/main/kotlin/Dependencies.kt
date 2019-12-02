import org.gradle.api.artifacts.dsl.RepositoryHandler

object BuildPlugin {
    const val applicationId = "com.codingwolf.dotadex"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlin = "kotlin"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object AndroidSdk {
    const val java = 1.8
    const val minSdk = 24
    const val compile = 29
    const val targetSdk = 29
    const val tools = "29.0.2"
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Dependencies {


    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Version.Implementation.AndroidX.core}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.Implementation.AndroidX.constraintLayout}"
        const val ktxCore = "androidx.core:core-ktx:${Version.Implementation.AndroidX.core}"
        const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Version.Implementation.AndroidX.lifecycle}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Implementation.AndroidX.lifecycle}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.Implementation.AndroidX.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.Implementation.AndroidX.navigation}"
    }

    object Gradle {
        const val android = "com.android.tools.build:gradle:${Version.Implementation.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Implementation.kotlin}"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Version.Implementation.detekt}"
    }

    object Kotlin {
        const val core = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.Implementation.kotlin}"
    }

    object Detekt {
        const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${Version.Implementation.detekt}"
    }


    object Square {
        const val moshi = "com.squareup.moshi:moshi:${Version.Implementation.Square.moshi}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Implementation.Square.retrofit}"
    }


    object Test {
        const val androidxCore = "androidx.test:core:${Version.Test.AndroidX.core}"
        const val androidxCoreArch = "androidx.arch.core:core-testing:${Version.Test.AndroidX.coreArch}"
        const val androidxJunit = "androidx.test.ext:junit:${Version.Test.AndroidX.junit}"
        const val androidxRunner = "androidx.test:runner:${Version.Test.AndroidX.core}"
        const val androidxRules = "androidx.test:rules:${Version.Test.AndroidX.core}"
        const val fragment = "androidx.fragment:fragment-testing:${Version.Test.AndroidX.fragment}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.Test.AndroidX.espressoCore}"
        const val junit = "junit:junit:${Version.Test.junit}"
        const val junitKtx = "androidx.test.ext:junit-ktx:${Version.Test.AndroidX.junit}"
        const val mockk = "io.mockk:mockk:${Version.Test.mockk}"
        const val mockkAndroid = "io.mockk:mockk-android:${Version.Test.mockk}"
        const val objenesis = "org.objenesis:objenesis:${Version.Test.objenesis}"
    }


    fun addRepos(handler: RepositoryHandler) {
        handler.google()
        handler.jcenter()
        handler.maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
}

object Version {
    object Implementation {

        object AndroidX {
            const val core = "1.1.0"
            const val constraintLayout = "1.1.3"
            const val lifecycle = "2.0.0"
            const val navigation = "2.1.0"
        }

        const val detekt = "1.1.1"
        const val gradle = "3.5.1"
        const val kotlin = "1.3.60"

        object Square {
            const val moshi = "1.9.2"
            const val retrofit = "2.6.2"
        }
    }

    object Test {
        object AndroidX {
            const val core = "1.1.0"
            const val coreArch = "2.0.1"
            const val junit = "1.1.1"
            const val espressoCore = "3.2.0"
            const val fragment = "1.1.0"
        }

        const val jacoco = "0.8.5"
        const val junit = "4.12"
        const val mockk = "1.9.3"
        const val objenesis = "2.6"
    }
}




