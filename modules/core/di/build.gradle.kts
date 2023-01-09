@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(deps.plugins.android.library)
    alias(deps.plugins.kotlin.android)
}

val configureAndroidOptions: Project.(withCompose: Boolean, withBuild: Boolean) -> Unit by rootProject.extra
configureAndroidOptions(false, false)

DependencyHandlerScope.of(dependencies).implementDi()