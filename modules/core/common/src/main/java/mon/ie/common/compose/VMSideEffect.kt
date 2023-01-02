package mon.ie.common.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import mon.ie.common.base.IESideEffect

@Composable
fun VMSideEffect(
    sideEffect: IESideEffect, onConsumed: () -> Unit, action: suspend () -> Unit
) {
    LaunchedEffect(key1 = sideEffect, key2 = onConsumed) {
        if (sideEffect.isTriggered) {
            action.invoke()
            onConsumed.invoke()
        }
    }
}