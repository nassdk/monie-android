import org.gradle.api.Project

class RootPluginsConfigurator : ModuleConfigurator {
    override fun configure(project: Project) {
        project.plugins.apply(Plugins.Project.detekt)
    }
}