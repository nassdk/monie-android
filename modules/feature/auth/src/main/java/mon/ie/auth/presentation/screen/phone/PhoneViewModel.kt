package mon.ie.auth.presentation.screen.phone

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class PhoneState : IEState
class PhoneIntent : IEIntent

internal class PhoneViewModel @Inject constructor() :
    IEViewModel<PhoneState, PhoneIntent>() {
    override val initialState = PhoneState()
}