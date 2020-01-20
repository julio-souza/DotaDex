plugins {
    id(BuildPlugin.kotlin)
    kotlin(BuildPlugin.kotlinKapt)
}

dependencies {
    implementation(project(":data"))

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Square.moshiKotlin)
    implementation(Dependencies.Square.okHttpLogging)
    implementation(Dependencies.Square.retrofit)
    implementation(Dependencies.Square.retrofitConverter)


    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)
}
repositories {
    mavenCentral()
}
