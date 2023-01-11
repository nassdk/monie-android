package configuration.base

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BuildType
import config.MonieConfig
import config.Version
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

internal fun Project.isApp(): Boolean {
    return project.name == MonieConfig.APP_PROJECT_NAME
}

internal fun Project.isRoot(): Boolean {
    return project.name == MonieConfig.ROOT_PROJECT_NAME
}

fun LibraryExtension.implementCompose() {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}