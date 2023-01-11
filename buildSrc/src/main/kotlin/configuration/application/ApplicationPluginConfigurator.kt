package configuration.application

import config.Plugins
import configuration.base.ModuleConfigurator
import org.gradle.api.Project

internal class ApplicationPluginConfigurator : ModuleConfigurator {

    override fun configure(project: Project) {
        with(project.plugins) {
            apply(Plugins.Project.application)
            apply(Plugins.Project.kotlinAndroid)
        }
    }
}