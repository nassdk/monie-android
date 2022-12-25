package mon.ie.auth.presentation.screen.phone

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IESideEffect
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class PhoneState : IEState
class PhoneSideEffect : IESideEffect
class PhoneIntent : IEIntent

internal class PhoneViewModel @Inject constructor() :
    IEViewModel<PhoneState, PhoneIntent, PhoneSideEffect>() {
    override val initialState = PhoneState()
}