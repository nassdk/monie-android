plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
    alias(deps.plugins.kotlin.serialization)
    alias(deps.plugins.kotlin.kapt)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, false)

dependencies {
    implementation(dependencyNotation = deps.kotlin.serializationJson)
    implementation(dependencyNotation = deps.retrofit)
    implementation(dependencyNotation = deps.retrofit.kotlinxSerializationConverter)
    implementation(dependencyNotation = deps.okhttp)
    implementation(dependencyNotation = deps.dagger)
    kapt(dependencyNotation = deps.dagger.compiler)
}