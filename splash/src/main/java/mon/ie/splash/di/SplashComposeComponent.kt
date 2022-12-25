package mon.ie.splash.di

import dagger.Subcomponent
import mon.ie.di.scope.ComposeScope
import mon.ie.splash.presentation.screen.SplashViewModel

@ComposeScope
@Subcomponent
internal interface SplashComposeComponent {
    val splashViewModel: SplashViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComposeComponent
    }
}