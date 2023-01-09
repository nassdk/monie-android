pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
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

setOf("$rootDir/modules/feature", "$rootDir/modules/core").forEach { dirName ->
    includeAllModules(dirName)
}

fun includeAllModules(dir: String, parent: String = "") {
    File(dir).listFiles()?.filter { it.isDirectory }?.forEach { module ->
        val moduleName = module.name
        if (isGradleModule(module)) {
            includeModule(name = moduleName, dir = dir, parent = parent)
        }
        if (parent.isBlank()) {
            includeAllModules("$dir/$moduleName", moduleName)
        }
    }
}

fun isGradleModule(file: File): Boolean {
    return File(
        "${file.absolutePath}/build.gradle.kts"
    ).exists()
}

fun includeModule(name: String, dir: String, parent: String = "") {
    val moduleName = if (parent.isNotBlank()) {
        "$parent:$name"
    } else {
        name
    }
    include(":$moduleName")
    project(":$moduleName").projectDir = File("$dir/$name")
}
