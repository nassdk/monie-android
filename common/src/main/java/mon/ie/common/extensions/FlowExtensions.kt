package mon.ie.common.extensions

import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> MutableSharedFlow<T>.tryEmit(
    value: T,
    onFailure: () -> Unit
) {
    val isEmittedSuccessfully = tryEmit(value = value)
    if (!isEmittedSuccessfully) {
        onFailure.invoke()
    }
}