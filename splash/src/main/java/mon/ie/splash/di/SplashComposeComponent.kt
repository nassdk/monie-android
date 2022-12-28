package mon.ie.splash.di

import dagger.Lazy
import dagger.Subcomponent
import mon.ie.di.scope.ComposeScope
import mon.ie.splash.presentation.screen.SplashViewModel

@ComposeScope
@Subcomponent
internal interface SplashComposeComponent {
    val splashViewModel: Lazy<SplashViewModel>

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComposeComponent
    }
}