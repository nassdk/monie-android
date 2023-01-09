object Dependencies {
    object Compose {
        const val activity = "androidx.activity:activity-compose:${Version.composeActivity}"
        const val navigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
        const val bom = "androidx.compose:compose-bom:${Version.composeBom}"
        const val ui = "androidx.compose.ui:ui"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material = "androidx.compose.material:material"
        const val animation = "androidx.compose.animation:animation"
        const val animationCore = "androidx.compose.animation:animation-core"
        const val animationGraphics = "androidx.compose.animation:animation-graphics"
        const val constraint = "androidx.constraintlayout:composeConstraintlayout"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
    }

    object Di {
        const val dagger = "com.google.dagger:dagger:${Version.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    }

    object Lifecycle {
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
        const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Version.lifecycle}"
    }

    object ImageLoad {
        const val coilCompose = "io.coil-kt:coil-compose:${Version.coil}"
        const val coilSvg = "io.coil-kt:coil-svg:${Version.coil}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    }

    object Grpc {
        const val protoBufLite = "io.grpc:grpc-protobuf-lite:${Version.grpcJava}"
        const val Okhttp = "io.grpc:grpc-okhttp:${Version.grpcJava}"
        const val stub = "io.grpc:grpc-stub:${Version.grpcJava}"
        const val kotlinStub = "io.grpc:grpc-kotlin-stub:${Version.grpcKotlinStub}"
        const val protobufJavaLite = "com.google.protobuf:protobuf-javalite:${Version.protoBufJavaLite}"
    }
}