package mon.ie.common.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

interface IEFeatureApi {
    @Composable
    fun NavGraph(scope: NavGraphBuilder)

    fun destroyModule()
}