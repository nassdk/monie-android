import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BuildType
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

internal fun NamedDomainObjectContainer<BuildType>.release(action: BuildType.() -> Unit) {
    getByName("release", action)
}

internal fun Project.setupAndroidBaseExtensions(block: BaseExtension.() -> Unit) {
    block(extensions.getByName("android") as BaseExtension)
}

internal fun Project.detekt(block: DetektExtension.() -> Unit) {
    block(extensions.getByName("detekt") as DetektExtension)
}

fun LibraryExtension.implementCompose() {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}