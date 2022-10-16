plugins {
  alias(deps.plugins.android.library)
  alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, false)

android {
  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = deps.versions.compose.compilerVersion.get()
  }
}

dependencies {
  implementation(dependencyNotation = projects.navigation)
  implementation(dependencyNotation = deps.coreKtx)
  implementation(dependencyNotation = deps.fragment)
  implementation(dependencyNotation = deps.appCompat)
  implementation(dependencyNotation = deps.compose.material)
  implementation(dependencyNotation = deps.dagger)
}