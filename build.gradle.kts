buildscript {
    dependencies {
        classpath(config.Plugins.Classpath.androidGradle)
        classpath(config.Plugins.Classpath.kotlinGradle)
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

apply(plugin = config.Plugins.Project.moduleConfigurator)

subprojects {
    apply(plugin = config.Plugins.Project.moduleConfigurator)
}