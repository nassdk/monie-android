import org.gradle.api.Project

internal interface ModuleConfigurator {
    fun configure(project: Project)
}