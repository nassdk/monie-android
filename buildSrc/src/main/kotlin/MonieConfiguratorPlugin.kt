import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.kotlin.dsl.provideDelegate

class MonieConfiguratorPlugin : Plugin<Project> {

    private val rootConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(RootPluginsConfigurator(), DetektConfigurator())
    }

    private val applicationConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(
            ApplicationPluginConfigurator(),
            ApplicationConfigurator(),
            ApplicationModulesImplementationPlugin()
        )
    }

    private val moduleConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(AndroidPluginsConfigurator(), AndroidModuleSettingsConfigurator())
    }

    override fun apply(target: Project) = with(target) {
        project.logger.log(LogLevel.DEBUG, "Configuring module ${target.name}")

        when {
            name == ROOT_PROJECT_NAME -> configureRootProject()
            name == APP_PROJECT_NAME -> configureApplication()
            else -> configureModule()
        }
    }

    private fun Project.configureRootProject() {
        rootConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private fun Project.configureApplication() {
        applicationConfigurators.forEach { configurator ->
            configurator.configure(project = project)
        }
    }

    private fun Project.configureModule() {
        moduleConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private companion object {
        private const val ROOT_PROJECT_NAME = "monie"
        private const val APP_PROJECT_NAME = "app"
    }
}