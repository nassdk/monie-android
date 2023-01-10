android.implementCompose()

dependencies {
    implementation(dependencyNotation = projects.theme)

    implementComposeBase()
    implementComposeAnimation()

    implementation(dependencyNotation = Dependencies.Compose.activity)
}