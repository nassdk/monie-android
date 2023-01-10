import org.gradle.api.Plugin
import org.gradle.api.Project

class MonieConfiguratorPlugin : Plugin<Project> {

    private val moduleConfigurators by lazy(LazyThreadSafetyMode.NONE) {
        arrayOf(AndroidPluginsConfigurator(), AndroidModuleSettingsConfigurator())
    }

    override fun apply(target: Project) = with(target) {
        if (name in ignoredModulesNames) return

        configureModule()
    }

    private fun Project.configureModule() {
        moduleConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private companion object {
        private const val ROOT_PROJECT_NAME = "monie"
        private const val APP_PROJECT_NAME = "app"
        private const val BUILDSRC_PROJECT_NAME = "buildSrc"

        private val ignoredModulesNames = arrayOf(
            ROOT_PROJECT_NAME, APP_PROJECT_NAME, BUILDSRC_PROJECT_NAME
        )
    }
}