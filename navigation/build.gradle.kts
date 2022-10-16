plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
    alias(deps.plugins.kotlin.kapt)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, true)

dependencies {
    implementation(dependencyNotation = deps.cicerone)
    implementation(dependencyNotation = deps.appCompat)
    implementation(dependencyNotation = deps.coreKtx)
    implementation(dependencyNotation = deps.fragment)
    implementation(dependencyNotation = deps.dagger)
    kapt(dependencyNotation = deps.dagger.compiler)
}