package mon.ie.auth.di

import dagger.Component
import mon.ie.auth.AuthApi
import mon.ie.di.scope.FeatureScope

@FeatureScope
@Component(modules = [AuthModule::class])
internal interface AuthComponent {
    val composeComponent: AuthComposeComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun moduleApi(): AuthApi
}