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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = deps.versions.compose.compilerVersion.get()
  }

  packagingOptions {
    resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
  }
}

dependencies {
  implementation(dependencyNotation = projects.ui)
  implementation(dependencyNotation = projects.common)
  implementation(dependencyNotation = projects.navigation)

  implementation(dependencyNotation = deps.bundles.compose)
  implementation(dependencyNotation = deps.compose.activity)
  implementation(dependencyNotation = deps.coreKtx)
  implementation(dependencyNotation = deps.fragment)
  debugImplementation(dependencyNotation = deps.compose.ui.tooling)
}