package mon.ie.auth.di

import dagger.Subcomponent
import mon.ie.auth.presentation.screen.phone.PhoneViewModel
import mon.ie.auth.presentation.screen.pin.PinViewModel
import mon.ie.di.scope.ComposeScope

@ComposeScope
@Subcomponent
internal interface AuthComposeComponent {
    val phoneViewModel: PhoneViewModel
    val pinViewModel: PinViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComposeComponent
    }
}