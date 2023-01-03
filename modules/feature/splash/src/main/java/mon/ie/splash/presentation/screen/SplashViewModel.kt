package mon.ie.splash.presentation.screen

import mon.ie.common.base.BaseIntent
import mon.ie.common.base.BaseState
import mon.ie.common.base.BaseViewModel
import javax.inject.Inject

class SplashState : BaseState
class SplashIntent : BaseIntent

class SplashViewModel @Inject constructor() :
    BaseViewModel<SplashState, SplashIntent>() {
    override val initialState = SplashState()
}