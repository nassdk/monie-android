plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("module-configurator") {
            id = "module.configurator"
            implementationClass = "MonieConfiguratorPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
}