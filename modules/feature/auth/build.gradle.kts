import config.Dependencies
import configuration.base.implementCompose
import configuration.base.implementComposeBase
import configuration.base.implementDiWithCompiler

plugins {
    id(config.Plugins.Project.kapt)
}

android.implementCompose()

dependencies {
    implementation(dependencyNotation = projects.di)
    implementation(dependencyNotation = projects.common)
    implementation(dependencyNotation = projects.theme)
    implementation(dependencyNotation = projects.uiKit)
    implementation(dependencyNotation = projects.navigation)

    implementComposeBase()
    implementDiWithCompiler()

    implementation(dependencyNotation = Dependencies.Compose.navigation)
    implementation(dependencyNotation = Dependencies.Lifecycle.runtimeCompose)
}