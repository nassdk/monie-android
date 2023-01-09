@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.library) apply false
    alias(deps.plugins.android.application) apply false
    alias(deps.plugins.kotlin.android) apply false
    alias(deps.plugins.kotlin.kapt) apply false
    alias(deps.plugins.kotlin.serialization) apply false
    alias(deps.plugins.detekt)
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

            packagingOptions {
                resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                kotlinOptions.jvmTarget = "1.8"
            }

            if (withCompose) {
                composeOptions.kotlinCompilerExtensionVersion = deps.versions.composeCompilerVersion.get()
            }

            buildFeatures.compose = withCompose
            buildFeatures.buildConfig = withBuild
        }
    }
)

detekt {
    config = files("${projectDir}/config/detekt/detekt.yml")
    allRules = false
    buildUponDefaultConfig = true
    parallel = true
    ignoreFailures = false
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    source = fileTree(projectDir)
    config.setFrom(files("${projectDir}/config/detekt/detekt.yml"))
    include("**/*.kt")
    exclude("**/resources/**", "**/build/**", "**/buildSrc/**")

    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
}

tasks.register<Copy>("copyGitHooks") {
    from("${rootDir}/config/githooks/") {
        include("**/*.sh")
        rename("(.*).sh", "$1")
    }
    into("${rootDir}/.git/hooks")
}

tasks.register<Exec>("installGitHooks") {
    group = "git hooks"
    workingDir = rootDir
    commandLine("chmod")
    args("-R", "+x", ".git/hooks/")
    dependsOn(getTasksByName("copyGitHooks", true))
    doLast {
        println("Git hook installed successfully.")
    }
}