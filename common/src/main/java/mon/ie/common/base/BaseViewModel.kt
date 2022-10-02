package mon.ie.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mon.ie.common.coroutines.CoroutinesDispatcherProvider

abstract class BaseViewModel<STATE : BaseScreenState, EVENT : BaseScreenEvent, COMMAND : BaseVmCommand>(
    protected val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider()
) : ViewModel() {

    protected abstract val initialState: STATE

    protected val _screenState by lazy {
        MutableStateFlow(initialState)
    }

    private val screenEventsSharedFlow = MutableSharedFlow<EVENT>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val _commands = MutableSharedFlow<COMMAND>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        screenEventsSharedFlow.onEach(::handleViewEvent).launchIn(viewModelScope)
    }

    internal val commands: SharedFlow<COMMAND>
        get() = _commands

    val screenState: StateFlow<STATE>
        get() = _screenState

    fun performViewEvent(event: EVENT) {
        screenEventsSharedFlow.tryEmit(value = event)
    }

    protected open fun handleViewEvent(event: EVENT) = Unit

    protected fun sendCommand(command: COMMAND) {
        _commands.tryEmit(value = command)
    }

    protected fun launchCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(/*context = CoroutineErrorHandler(),*/ block = body)

    protected fun launchIoCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job = launchCoroutine(
        body = {
            withContext(context = dispatcherProvider.io, block = body)
        }
    )
}