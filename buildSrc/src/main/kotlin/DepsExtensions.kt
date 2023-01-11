import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    add(configurationName = "implementation", dependencyNotation = dependencyNotation)
}

internal fun DependencyHandlerScope.debugImplementation(dependencyNotation: Any) {
    add(configurationName = "debugImplementation", dependencyNotation = dependencyNotation)
}

internal fun DependencyHandlerScope.kapt(dependencyNotation: Any) {
    add(configurationName = "kapt", dependencyNotation = dependencyNotation)
}

internal fun Project.implementModule(moduleName: String) {
    dependencies.add(
        "implementation",
        dependencies.project(
            mapOf("path" to ":$moduleName")
        )
    )
}

fun DependencyHandlerScope.implementDiWithCompiler() {
    implementation(dependencyNotation = Dependencies.Di.dagger)
    kapt(dependencyNotation = Dependencies.Di.daggerCompiler)
}

fun DependencyHandlerScope.implementDi() {
    implementation(dependencyNotation = Dependencies.Di.dagger)
}

fun DependencyHandlerScope.implementComposeBom() {
    val bom = platform(notation = Dependencies.Compose.bom)
    implementation(dependencyNotation = bom)
    debugImplementation(dependencyNotation = bom)
}

fun DependencyHandlerScope.implementComposeBase() {
    implementComposeBom()
    implementation(dependencyNotation = Dependencies.Compose.ui)
    implementation(dependencyNotation = Dependencies.Compose.material)
    implementation(dependencyNotation = Dependencies.Compose.uiToolingPreview)
}


fun DependencyHandlerScope.implementComposeAnimation() {
    implementation(dependencyNotation = Dependencies.Compose.animation)
    implementation(dependencyNotation = Dependencies.Compose.animationCore)
    implementation(dependencyNotation = Dependencies.Compose.animationGraphics)
}
