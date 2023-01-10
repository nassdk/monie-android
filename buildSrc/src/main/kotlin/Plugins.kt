object Plugins {
    object Classpath {
        const val androidGradle = "com.android.tools.build:gradle:7.3.1"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0"
    }

    object Project {
        const val kapt = "org.jetbrains.kotlin.kapt"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val application = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val moduleConfigurator = "module.configurator"
    }
}