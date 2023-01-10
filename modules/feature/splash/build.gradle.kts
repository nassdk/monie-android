plugins {
    id(Plugins.Project.kapt)
}

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}

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