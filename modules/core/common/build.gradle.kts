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

    implementDi()
    implementComposeBom()
    implementation(dependencyNotation = Dependencies.Compose.navigation)

    implementation(dependencyNotation = Dependencies.AndroidX.coreKtx)
    implementation(dependencyNotation = Dependencies.AndroidX.appCompat)

    implementation(dependencyNotation = Dependencies.Lifecycle.viewModelCompose)
}