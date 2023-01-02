package mon.ie.splash.presentation.screen

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class SplashState : IEState
class SplashIntent : IEIntent

class SplashViewModel @Inject constructor() :
    IEViewModel<SplashState, SplashIntent>() {
    override val initialState = SplashState()
}