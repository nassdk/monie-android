import org.gradle.api.Project

class AndroidPluginsConfigurator : ModuleConfigurator {
    override fun configure(project: Project) {
        with(project.plugins) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }
    }
}