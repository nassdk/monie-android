pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    enableFeaturePreview("VERSION_CATALOGS")
    enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("deps") {
            from(files("../monie-android/gradle/deps.versions.toml"))
        }
        create("config") {
            from(files("../monie-android/gradle/config.versions.toml"))
        }
    }
}
rootProject.name = "monie"
include("app")
include("network")
include(":common")
include(":navigation")
include(":theme")
include(":ui-kit")
