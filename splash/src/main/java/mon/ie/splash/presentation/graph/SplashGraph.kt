package mon.ie.splash.presentation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import mon.ie.common.delegates.scopedComponent
import mon.ie.navigation.lifecycle.ComposableLifecycleStateModel
import mon.ie.navigation.lifecycleComposable
import mon.ie.splash.di.SplashComponent
import mon.ie.splash.presentation.screen.SplashScreen

@Composable
internal fun NavGraphBuilder.SplashGraph(
    onComposableStateChanged: (model: ComposableLifecycleStateModel) -> Unit,
    navController: NavController,
    component: SplashComponent
) {
    navigation(
        startDestination = "splash",
        route = "starter",
        builder = {

            lifecycleComposable(
                route = "splash",
                composableStateChanged = { model ->
                    onComposableStateChanged(model)
                },
                content = { entry ->
                    val composeComponent by entry.scopedComponent {
                        component.composeComponent.create()
                    }

                    SplashScreen(
                        navController = navController,
                        viewModel = composeComponent.splashViewModel
                    )
                }
            )
        }
    )
}