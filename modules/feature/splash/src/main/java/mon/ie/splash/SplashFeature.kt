package mon.ie.splash

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import mon.ie.common.base.FeatureFacade
import mon.ie.common.extensions.nullable
import mon.ie.splash.di.DaggerSplashComponent
import mon.ie.splash.di.SplashComponent
import mon.ie.splash.presentation.graph.SplashGraph

class SplashFeature : FeatureFacade<SplashApi>(destroyOnEmptyComposables = true) {

    private var component: SplashComponent? by nullable {
        DaggerSplashComponent.factory().create()
    }

    override val api
        get() = requireNotNull(component).moduleApi()

    @Composable
    override fun ModuleNavGraph(scope: NavGraphBuilder, navController: NavController) {
        scope.SplashGraph(
            onComposableStateChanged = ::composableStateChanged,
            navController = navController,
            component = requireNotNull(component)
        )
    }

    override fun destroyGraph() {
        component = null
    }
}

