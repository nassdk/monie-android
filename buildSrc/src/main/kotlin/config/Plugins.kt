package config

object Plugins {
    object Classpath {
        const val androidGradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    }

    object Project {
        const val kapt = "org.jetbrains.kotlin.kapt"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val library = "com.android.library"
        const val application = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val moduleConfigurator = "mon.ie.configurator"
    }
}