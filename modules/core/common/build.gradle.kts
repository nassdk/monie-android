android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}

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