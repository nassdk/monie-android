android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}

dependencies {
    implementation(dependencyNotation = projects.theme)

    implementComposeBase()
    implementComposeAnimation()

    implementation(dependencyNotation = Dependencies.Compose.activity)
}