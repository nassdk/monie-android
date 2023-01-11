import config.Dependencies
import configuration.base.implementCompose
import configuration.base.implementComposeBom
import configuration.base.implementDi

android.implementCompose()

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