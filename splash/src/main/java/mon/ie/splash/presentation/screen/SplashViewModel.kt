package mon.ie.splash.presentation.screen

import mon.ie.common.base.IEIntent
import mon.ie.common.base.IESideEffect
import mon.ie.common.base.IEState
import mon.ie.common.base.IEViewModel
import javax.inject.Inject

class SplashState : IEState
class SplashSideEffect : IESideEffect
class SplashIntent : IEIntent

class SplashViewModel @Inject constructor() :
    IEViewModel<SplashState, SplashIntent, SplashSideEffect>() {
    override val initialState = SplashState()
}