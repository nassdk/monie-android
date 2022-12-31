@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(true, false)

dependencies {
    implementation(dependencyNotation = projects.theme)

    implementation(dependencyNotation = deps.compose.activity)
    implementation(dependencyNotation = deps.bundles.compose.basepack)
    implementation(dependencyNotation = deps.bundles.compose.animationpack)
}