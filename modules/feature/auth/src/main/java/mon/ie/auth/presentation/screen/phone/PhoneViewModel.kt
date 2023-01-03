package mon.ie.auth.presentation.screen.phone

import mon.ie.common.base.BaseIntent
import mon.ie.common.base.BaseState
import mon.ie.common.base.BaseViewModel
import javax.inject.Inject

class PhoneState : BaseState
class PhoneIntent : BaseIntent

internal class PhoneViewModel @Inject constructor() :
    BaseViewModel<PhoneState, PhoneIntent>() {
    override val initialState = PhoneState()
}