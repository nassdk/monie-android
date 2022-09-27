plugins {
    alias(deps.plugins.android.library) apply false
    alias(deps.plugins.android.application) apply false
    alias(deps.plugins.kotlin.android) apply false
    alias(deps.plugins.kotlin.kapt) apply false
    alias(deps.plugins.kotlin.serialization) apply false
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by extra(
    fun Project.(withCompose: Boolean, withBuild: Boolean) {

        extensions.configure<com.android.build.gradle.BaseExtension> {
            defaultConfig {
                compileSdkVersion(config.versions.compileSdk.get().toInt())
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
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            packagingOptions {
                resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                kotlinOptions.jvmTarget = "1.8"
            }

            if (withCompose) {
                composeOptions.kotlinCompilerExtensionVersion = deps.versions.compose.compilerVersion.get()
                dependencies.addCompose()
            }

            buildFeatures.compose = withCompose
            buildFeatures.buildConfig = withBuild
        }
    }
)

fun DependencyHandler.addCompose() {
    deps.bundles.compose.get().forEach { dep ->
        add("implementation", dep)
    }
    add("debugImplementation", deps.compose.ui.tooling)
}