package mon.ie.auth.presentation.screen.pin

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IESideEffect
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class PinState : IEState
class PinSideEffect : IESideEffect
class PinIntent : IEIntent

internal class PinViewModel @Inject constructor() :
    IEViewModel<PinState, PinIntent, PinSideEffect>() {
    override val initialState = PinState()
}