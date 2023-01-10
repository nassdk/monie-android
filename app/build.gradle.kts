@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.application)
    alias(deps.plugins.kotlin.android)
}

android {
    namespace = config.versions.appId.get()
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = config.versions.appId.get()
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()
        versionCode = config.versions.versionCode.get().toInt()
        versionName = config.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = deps.versions.composeCompilerVersion.get()
    }

    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementComposeBase()
    implementation(dependencyNotation = Dependencies.Compose.navigation)
    implementation(dependencyNotation = Dependencies.Compose.activity)
    implementation(dependencyNotation = Dependencies.AndroidX.coreKtx)

    setOf("$rootDir/modules/feature", "$rootDir/modules/core").forEach { dirName ->
        File(dirName).listFiles()
            ?.filter { it.isDirectory }
            ?.forEach { module ->
                val moduleName = module.name
                if (File("${module.absolutePath}/build.gradle.kts").exists()) {
                    implementation(project(":$moduleName"))
                }
            }
    }
}