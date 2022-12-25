package mon.ie.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import mon.ie.navigation.lifecycle.ComposableLifecycleState.CREATED
import mon.ie.navigation.lifecycle.ComposableLifecycleState.DESTROYED
import mon.ie.navigation.lifecycle.ComposableLifecycleStateModel

fun NavGraphBuilder.lifecycleComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    composableStateChanged: (ComposableLifecycleStateModel) -> Unit,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    val lifecycleObserver by lazy {
        object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                composableStateChanged.invoke(
                    ComposableLifecycleStateModel(
                        state = CREATED,
                        route = route
                    )
                )
            }

            override fun onDestroy(owner: LifecycleOwner) {
                composableStateChanged.invoke(
                    ComposableLifecycleStateModel(
                        state = DESTROYED,
                        route = route
                    )
                )
            }
        }
    }

    composable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = { entry ->
            entry.lifecycle.addObserver(lifecycleObserver)
            content.invoke(entry)
        }
    )
}