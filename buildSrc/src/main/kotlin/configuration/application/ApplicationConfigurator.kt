package configuration.application

import com.android.build.gradle.BaseExtension
import config.MonieConfig
import config.Version
import configuration.base.ModuleConfigurator
import configuration.base.release
import configuration.base.setupAndroidBaseExtensions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class ApplicationConfigurator : ModuleConfigurator {

    override fun configure(project: Project) {
        project.setupAndroidBaseExtensions {
            configureDefaultConfig()
            configureBuildTypes()
            configureCompileOptions()
            configurePackagingOptions()
            configureComposeOptions()
            configureBuildFeatures()
            configureKotlinOptions(project = project)
        }
    }

    private fun BaseExtension.configureDefaultConfig() {
        defaultConfig {
            compileSdkVersion(MonieConfig.compileSdk)

            applicationId = MonieConfig.appId
            namespace = MonieConfig.appId

            minSdk = MonieConfig.minSdk
            targetSdk = MonieConfig.targetSdk

            versionCode = MonieConfig.versionCode
            versionName = MonieConfig.versionName

            testInstrumentationRunner = MonieConfig.runner
            vectorDrawables.useSupportLibrary = true
        }
    }

    private fun BaseExtension.configureBuildTypes() {
        buildTypes.release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(MonieConfig.androidDefaultProguardFileName),
                MonieConfig.proguardFileName
            )
        }
    }

    private fun BaseExtension.configureCompileOptions() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun configureKotlinOptions(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun BaseExtension.configureComposeOptions() {
        composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
    }

    private fun BaseExtension.configureBuildFeatures() {
        buildFeatures.compose = true
    }

    private fun BaseExtension.configurePackagingOptions() {
        packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}