package mon.ie.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mon.ie.common.coroutines.CoroutinesDispatcherProvider

abstract class IEViewModel<STATE : IEState, INTENT : IEIntent>(
    protected val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider()
) : ViewModel() {

    protected abstract val initialState: STATE

    protected val screenStateMutable by lazy {
        MutableStateFlow(initialState)
    }

    protected fun updateState(block: STATE.() -> STATE) {
        screenStateMutable.value = block.invoke(stateFlow.value)
    }

    val stateFlow: StateFlow<STATE>
        get() = screenStateMutable

    open fun intent(intent: INTENT) {}
}