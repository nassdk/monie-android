@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(true, false)

dependencies {
    implementation(dependencyNotation = projects.di)
    implementation(dependencyNotation = projects.navigation)
    implementation(dependencyNotation = deps.coreKtx)
    implementation(dependencyNotation = deps.appCompat)
    implementation(dependencyNotation = deps.compose.material)
    implementation(dependencyNotation = deps.compose.navigation)
    implementation(dependencyNotation = deps.dagger)
    implementation(dependencyNotation = deps.lifecycle.viewmodelCompose)
}