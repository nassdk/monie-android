package mon.ie.common.base

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import mon.ie.navigation.lifecycle.ComposableLifecycleStateModel
import mon.ie.navigation.lifecycle.isCreated

abstract class FeatureFacade<Api>(protected val destroyOnEmptyComposables: Boolean) {

    private val activeComposables by lazy {
        hashSetOf<String>()
    }

    protected abstract fun destroyGraph()

    @Composable
    abstract fun ModuleNavGraph(scope: NavGraphBuilder, navController: NavController)

    protected abstract val api: Api
    protected open val onComposablesEmpty: () -> Unit = {}

    protected fun composableStateChanged(model: ComposableLifecycleStateModel) {
        if (model.state.isCreated()) {
            activeComposables.add(model.route)
        } else {
            activeComposables.remove(model.route)
            checkIfThereAnyActive()
        }
    }

    private fun checkIfThereAnyActive() {
        if (activeComposables.isEmpty()) {
            onComposablesEmpty.invoke()

            if (destroyOnEmptyComposables) {
                Log.d(
                    "FeatureFacade",
                    "graph is destroyed for api ${api!!::class.java.canonicalName}"
                )
                destroyGraph()
            }
        }
    }
}