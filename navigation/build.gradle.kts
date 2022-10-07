plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, false)

dependencies {
    implementation(dependencyNotation = deps.cicerone)
    implementation(dependencyNotation = deps.appCompat)
    implementation(dependencyNotation = deps.coreKtx)
}