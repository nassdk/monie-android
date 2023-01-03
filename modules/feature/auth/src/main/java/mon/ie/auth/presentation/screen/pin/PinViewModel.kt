package mon.ie.auth.presentation.screen.pin

import mon.ie.common.base.BaseIntent
import mon.ie.common.base.BaseState
import mon.ie.common.base.BaseViewModel
import javax.inject.Inject

class PinState : BaseState
class PinIntent : BaseIntent

internal class PinViewModel @Inject constructor() :
    BaseViewModel<PinState, PinIntent>() {
    override val initialState = PinState()
}