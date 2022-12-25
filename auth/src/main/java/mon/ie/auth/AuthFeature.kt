package mon.ie.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import mon.ie.auth.di.AuthComponent
import mon.ie.auth.di.DaggerAuthComponent
import mon.ie.auth.presentation.graph.AuthGraph
import mon.ie.common.base.FeatureFacade
import mon.ie.common.extensions.nullable

class AuthFeature : FeatureFacade<AuthApi>(destroyOnEmptyComposables = true) {

    private var component: AuthComponent? by nullable {
        DaggerAuthComponent.factory().create()
    }

    override val api
        get() = requireNotNull(component).moduleApi()

    @Composable
    override fun ModuleNavGraph(scope: NavGraphBuilder, navController: NavController) {
        scope.AuthGraph(
            onComposableStateChanged = ::composableStateChanged,
            navController = navController,
            component = requireNotNull(component)
        )
    }

    override fun destroyGraph() {
        component = null
    }
}

