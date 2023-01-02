package mon.ie.auth.presentation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import mon.ie.auth.di.AuthComponent
import mon.ie.auth.presentation.screen.phone.PhoneScreen
import mon.ie.auth.presentation.screen.pin.PinScreen
import mon.ie.common.delegates.scopedComponent
import mon.ie.common.extensions.composableAwareViewModel
import mon.ie.navigation.lifecycle.ComposableLifecycleStateModel
import mon.ie.navigation.lifecycleComposable

@Composable
internal fun NavGraphBuilder.AuthGraph(
    onComposableStateChanged: (model: ComposableLifecycleStateModel) -> Unit,
    navController: NavController,
    component: AuthComponent
) {
    navigation(
        startDestination = "phone",
        route = "auth",
        builder = {
            lifecycleComposable(
                route = "phone",
                composableStateChanged = { model ->
                    onComposableStateChanged.invoke(model)
                },
                content = { entry ->
                    val composeComponent by entry.scopedComponent {
                        component.composeComponent().create()
                    }

                    PhoneScreen(
                        navController = navController,
                        viewModel = composableAwareViewModel(
                            owner = entry,
                            creator = { _ ->
                                composeComponent.phoneViewModel.get()
                            }
                        )
                    )
                }
            )

            lifecycleComposable(
                route = "pin",
                composableStateChanged = { model ->
                    onComposableStateChanged.invoke(model)
                },
                content = { entry ->
                    val composeComponent by entry.scopedComponent {
                        component.composeComponent().create()
                    }

                    PinScreen(
                        navController = navController,
                        viewModel = composableAwareViewModel(
                            owner = entry,
                            creator = { _ ->
                                composeComponent.pinViewModel.get()
                            }
                        )
                    )
                }
            )
        }
    )
}