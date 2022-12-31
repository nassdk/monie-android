package mon.ie.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mon.ie.common.coroutines.CoroutinesDispatcherProvider
import mon.ie.common.extensions.tryEmit

abstract class IEViewModel<STATE : IEState, INTENT : IEIntent, SIDEEFFECT : IESideEffect>(
    protected val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider()
) : ViewModel() {

    protected abstract val initialState: STATE

    protected val screenStateMutable by lazy {
        MutableStateFlow(initialState)
    }

    private val intentsMutableFlow = MutableSharedFlow<INTENT>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val sideEffectMutableFlow = MutableSharedFlow<SIDEEFFECT>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        intentsMutableFlow.onEach(::handleIntent).launchIn(viewModelScope)
    }

    internal val sideEffectFlow: SharedFlow<SIDEEFFECT>
        get() = sideEffectMutableFlow

    val screenState: StateFlow<STATE>
        get() = screenStateMutable

    fun intent(intent: INTENT) {
        intentsMutableFlow.tryEmit(
            value = intent,
            onFailure = {
                viewModelScope.launch {
                    intentsMutableFlow.emit(value = intent)
                }
            }
        )
    }

    protected fun emitSideEffect(sideEffect: SIDEEFFECT) {
        sideEffectMutableFlow.tryEmit(
            value = sideEffect,
            onFailure = {
                viewModelScope.launch {
                    sideEffectMutableFlow.emit(value = sideEffect)
                }
            }
        )
    }

    protected open fun handleIntent(intent: INTENT) = Unit
}