import config.Dependencies
import configuration.base.implementComposeBase

dependencies {
    implementComposeBase()
    implementation(dependencyNotation = Dependencies.Compose.navigation)
    implementation(dependencyNotation = Dependencies.Compose.activity)
    implementation(dependencyNotation = Dependencies.AndroidX.coreKtx)
}