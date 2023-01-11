import config.Dependencies
import configuration.base.implementCompose
import configuration.base.implementComposeAnimation
import configuration.base.implementComposeBase

android.implementCompose()

dependencies {
    implementation(dependencyNotation = projects.theme)

    implementComposeBase()
    implementComposeAnimation()

    implementation(dependencyNotation = Dependencies.Compose.activity)
}