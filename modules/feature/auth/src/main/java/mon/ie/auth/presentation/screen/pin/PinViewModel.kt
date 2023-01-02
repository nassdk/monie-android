package mon.ie.auth.presentation.screen.pin

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class PinState : IEState
class PinIntent : IEIntent

internal class PinViewModel @Inject constructor() :
    IEViewModel<PinState, PinIntent>() {
    override val initialState = PinState()
}