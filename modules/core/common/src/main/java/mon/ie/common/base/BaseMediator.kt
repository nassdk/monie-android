package mon.ie.common.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

abstract class BaseMediator {

    @Composable
    fun NavGraph(scope: NavGraphBuilder, navController: NavController) {
        feature.ModuleNavGraph(scope = scope, navController = navController)
    }

    abstract val feature: FeatureFacade<*>
    abstract fun clearFeature()
}