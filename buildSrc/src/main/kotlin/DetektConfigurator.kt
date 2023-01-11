import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Exec
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

class DetektConfigurator : ModuleConfigurator {

    override fun configure(project: Project) {
        with(project) {
            configureDetekt()
            configureDetektTask()
            configureHookTasks()
        }
    }

    private fun Project.configureDetekt() {
        detekt {
            config = files("${projectDir}/config/detekt/detekt.yml")
            allRules = false
            buildUponDefaultConfig = true
            parallel = true
            ignoreFailures = false
        }
    }

    private fun Project.configureDetektTask() {
        tasks.withType<Detekt>().configureEach {
            source = fileTree(projectDir)
            config.setFrom(files("${projectDir}/config/detekt/detekt.yml"))
            include("**/*.kt")
            exclude("**/resources/**", "**/build/**", "**/buildSrc/**")

            reports {
                xml.required.set(true)
                html.required.set(true)
                txt.required.set(true)
                sarif.required.set(true)
                md.required.set(true)
            }
        }
    }

    private fun Project.configureHookTasks() {
        tasks.register<Copy>("copyGitHooks") {
            from("${rootDir}/config/githooks/") {
                include("**/*.sh")
                rename("(.*).sh", "$1")
            }
            into("${rootDir}/.git/hooks")
        }

        tasks.register<Exec>("installGitHooks") {
            group = "git hooks"
            workingDir = rootDir
            commandLine("chmod")
            args("-R", "+x", ".git/hooks/")
            dependsOn(getTasksByName("copyGitHooks", true))
            doLast {
                println("Git hook installed successfully.")
            }
        }
    }
}