plugins {
    id(BuildPlugin.kotlin)
    kotlin(BuildPlugin.kotlinKapt)
}

dependencies {
    implementation(project(":data"))


    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.coroutines)
}
