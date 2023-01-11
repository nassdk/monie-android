import org.gradle.api.Project

class ApplicationPluginConfigurator : ModuleConfigurator {

    override fun configure(project: Project) {
        with(project.plugins) {
            apply(Plugins.Project.application)
            apply(Plugins.Project.kotlinAndroid)
        }
    }
}