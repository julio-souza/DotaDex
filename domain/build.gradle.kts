plugins {
    id(BuildPlugin.kotlin)
}

dependencies {
    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Square.moshi)
}
