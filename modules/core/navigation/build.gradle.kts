import config.Dependencies
import configuration.base.implementCompose
import configuration.base.implementComposeBase

android.implementCompose()

dependencies {
    implementComposeBase()
    implementation(dependencyNotation = Dependencies.Compose.navigation)
}