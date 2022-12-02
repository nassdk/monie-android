plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(true, false)

dependencies {
    implementation(projects.theme)
    implementation(deps.fragment)
    implementation(deps.compose.activity)
    implementation(deps.compose.animation)
    implementation(deps.compose.animation.core)
    implementation(deps.compose.animation.graphics)
}