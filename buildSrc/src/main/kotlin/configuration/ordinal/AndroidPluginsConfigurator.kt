package configuration.ordinal

import config.Plugins
import configuration.base.ModuleConfigurator
import org.gradle.api.Project

internal class AndroidPluginsConfigurator : ModuleConfigurator {
    override fun configure(project: Project) {
        with(project.plugins) {
            apply(Plugins.Project.library)
            apply(Plugins.Project.kotlinAndroid)
        }
    }
}