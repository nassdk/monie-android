android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}

DependencyHandlerScope.of(dependencies).implementComposeBase()