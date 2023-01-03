package mon.ie.android.mediator

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import mon.ie.common.base.BaseMediator

object MediatorManager {
    private val mediators = mutableListOf<BaseMediator>()

    val splashMediator = SplashMediator().also(mediators::add)
    val authMediator = AuthMediator().also(mediators::add)

    @Composable
    fun AppDestinations(scope: NavGraphBuilder, navController: NavController) {
        mediators.forEach { mediator ->
            mediator.NavGraph(scope = scope, navController = navController)
        }
    }

    fun clearMediators() {
        mediators.forEach(BaseMediator::clearFeature)
        mediators.clear()
    }
}