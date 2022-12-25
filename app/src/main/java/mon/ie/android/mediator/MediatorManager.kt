package mon.ie.android.mediator

object MediatorManager {
    val splashMediator by lazy { SplashMediator() }
    val authMediator by lazy { AuthMediator() }

    fun clearMediators() {
        splashMediator.clearFeature()
        authMediator.clearFeature()
    }
}