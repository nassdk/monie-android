plugins {
    id(Plugins.Project.application)
    id(Plugins.Project.kotlinAndroid)
}

android {
    namespace = MonieConfig.appId
    compileSdk = MonieConfig.compileSdk

    defaultConfig {
        applicationId = MonieConfig.appId
        minSdk = MonieConfig.minSdk
        targetSdk = MonieConfig.targetSdk
        versionCode = MonieConfig.versionCode
        versionName = MonieConfig.versionName

        testInstrumentationRunner = MonieConfig.runner
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(MonieConfig.androidDefaultProguardFileName),
                MonieConfig.proguardFileName
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

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Version.composeCompiler
    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
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