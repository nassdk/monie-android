package mon.ie.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.createGraph
import mon.ie.android.mediator.MediatorManager

@Composable
internal fun NavHostController.createAppNavGraph(): NavGraph {
    return createGraph(
        startDestination = "starter",
        builder = {
            MediatorManager.AppDestinations(
                scope = this,
                navController = this@createAppNavGraph
            )
        }
    )
}