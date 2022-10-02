plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
    alias(deps.plugins.kotlin.kapt)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, false)

dependencies {
    implementation(dependencyNotation = deps.coreKtx)
    implementation(dependencyNotation = deps.fragment)
    implementation(dependencyNotation = deps.appCompat)
    implementation(dependencyNotation = deps.compose.material)
    implementation(dependencyNotation = deps.dagger)
}