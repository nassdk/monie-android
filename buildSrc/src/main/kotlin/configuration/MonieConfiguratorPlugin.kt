package configuration

import configuration.application.ApplicationConfigurator
import configuration.application.ApplicationModulesImplementationPlugin
import configuration.application.ApplicationPluginConfigurator
import configuration.base.isApp
import configuration.base.isRoot
import configuration.ordinal.AndroidModuleSettingsConfigurator
import configuration.ordinal.AndroidPluginsConfigurator
import configuration.root.DetektConfigurator
import configuration.root.RootPluginsConfigurator
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.kotlin.dsl.provideDelegate

internal class MonieConfiguratorPlugin : Plugin<Project> {

    private val rootConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(
            RootPluginsConfigurator(),
            DetektConfigurator()
        )
    }

    private val applicationConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(
            ApplicationPluginConfigurator(),
            ApplicationConfigurator(),
            ApplicationModulesImplementationPlugin()
        )
    }

    private val projectModuleConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(
            AndroidPluginsConfigurator(),
            AndroidModuleSettingsConfigurator()
        )
    }

    override fun apply(target: Project) = with(target) {
        logger.log(LogLevel.DEBUG, "Configuring module $name")

        when {
            isRoot() -> configureRootProject()
            isApp() -> configureApplicationModule()
            else -> configureProjectModule()
        }
    }

    private fun Project.configureRootProject() {
        rootConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private fun Project.configureApplicationModule() {
        applicationConfigurators.forEach { configurator ->
            configurator.configure(project = project)
        }
    }

    private fun Project.configureProjectModule() {
        projectModuleConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }
}