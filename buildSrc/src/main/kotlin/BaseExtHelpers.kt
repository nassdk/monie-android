import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

internal fun NamedDomainObjectContainer<BuildType>.release(action: BuildType.() -> Unit) {
    getByName("release", action)
}

internal fun Project.setupAndroidBaseExtensions(block: BaseExtension.() -> Unit) {
    block(extensions.getByName("android") as BaseExtension)
}

fun LibraryExtension.implementCompose() {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
}