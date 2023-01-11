dependencies {
    implementComposeBase()
    implementation(dependencyNotation = Dependencies.Compose.navigation)
    implementation(dependencyNotation = Dependencies.Compose.activity)
    implementation(dependencyNotation = Dependencies.AndroidX.coreKtx)

//    setOf("$rootDir/modules/feature", "$rootDir/modules/core").forEach { dirName ->
//        File(dirName).listFiles()
//            ?.filter { it.isDirectory }
//            ?.forEach { module ->
//                val moduleName = module.name
//                if (File("${module.absolutePath}/build.gradle.kts").exists()) {
//                    implementation(project(":$moduleName"))
//                }
//            }
//    }
}