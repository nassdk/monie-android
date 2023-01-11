buildscript {
    dependencies {
        classpath(Plugins.Classpath.androidGradle)
        classpath(Plugins.Classpath.kotlinGradle)
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

apply(plugin = Plugins.Project.moduleConfigurator)

subprojects {
    apply(plugin = Plugins.Project.moduleConfigurator)
}