plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

val configureAndroidOptions: Project.(
    withCompose: Boolean,
    withBuild: Boolean,
    withSerialization: Boolean,
    withParcelize: Boolean
) -> Unit by extra(
    fun Project.(
        withCompose: Boolean,
        withBuild: Boolean,
        withSerialization: Boolean,
        withParcelize: Boolean
    ) {
        apply(deps.plugins.android.library)
        apply(deps.plugins.kotlin.android)
        applyIfTrue(deps.plugins.kotlin.serialization, withSerialization)
        applyIfTrue(deps.plugins.kotlin.parcelize, withParcelize)

        extensions.configure<com.android.build.gradle.BaseExtension> {
            defaultConfig {
                compileSdkVersion = config.versions.compileSdk.get()
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
                kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
            }

            if (withCompose) {
                composeOptions.kotlinCompilerExtensionVersion = "1.3.1"
                dependencies.addCompose()
            }

            buildFeatures.compose = withCompose
            buildFeatures.buildConfig = withBuild
        }
    }
)

fun PluginAware.applyIfTrue(from: Any, condition: Boolean) {
    if (condition) apply(from)
}

fun DependencyHandler.addCompose() {
    deps.bundles.compose.get().forEach { dep ->
        add("implementation", dep)
    }
    add("debugImplementation", deps.compose.ui.tooling)
}