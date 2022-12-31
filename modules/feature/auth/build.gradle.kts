@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
    alias(deps.plugins.kotlin.kapt)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(true, false)

dependencies {
    implementation(dependencyNotation = projects.di)
    implementation(dependencyNotation = projects.common)
    implementation(dependencyNotation = projects.theme)
    implementation(dependencyNotation = projects.uiKit)
    implementation(dependencyNotation = projects.navigation)

    implementation(dependencyNotation = deps.bundles.compose.basepack)
    implementation(dependencyNotation = deps.compose.navigation)

    implementation(dependencyNotation = deps.dagger)
    kapt(dependencyNotation = deps.dagger.compiler)
}