package configuration.root

import config.Plugins
import configuration.base.ModuleConfigurator
import org.gradle.api.Project

internal class RootPluginsConfigurator : ModuleConfigurator {
    override fun configure(project: Project) {
        project.plugins.apply(Plugins.Project.detekt)
    }
}