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

plugins {
    id(Plugins.Project.detekt) version Version.detekt
}

repositories {
    mavenCentral()
}

apply(plugin = Plugins.Project.moduleConfigurator)

subprojects {
    apply(plugin = Plugins.Project.moduleConfigurator)
}

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