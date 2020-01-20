plugins {
    id(BuildPlugin.kotlin)
    kotlin(BuildPlugin.kotlinKapt)
}

dependencies {
    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Square.moshi)
    implementation(Dependencies.Square.retrofitConverter)
    implementation(Dependencies.Square.retrofit)
}
repositories {
    mavenCentral()
}
