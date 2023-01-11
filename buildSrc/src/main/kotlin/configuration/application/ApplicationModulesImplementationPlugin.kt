package configuration.application

import configuration.base.ModuleConfigurator
import configuration.base.implementModule
import org.gradle.api.Project
import java.io.File

internal class ApplicationModulesImplementationPlugin : ModuleConfigurator {

    override fun configure(project: Project) {
        val rootDir = project.rootDir

        setOf("$rootDir/modules/feature", "$rootDir/modules/core").forEach { dirName ->
            File(dirName).listFiles()
                ?.filter { it.isDirectory }
                ?.forEach { module ->
                    val moduleName = module.name
                    if (File("${module.absolutePath}/build.gradle.kts").exists()) {
                        project.implementModule(moduleName = moduleName)
                    }
                }
        }
    }
}