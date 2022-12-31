package mon.ie.splash.di

import dagger.Component
import mon.ie.di.scope.FeatureScope
import mon.ie.splash.SplashApi

@FeatureScope
@Component(modules = [SplashModule::class])
internal interface SplashComponent {
    fun composeComponent(): SplashComposeComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun moduleApi(): SplashApi
}