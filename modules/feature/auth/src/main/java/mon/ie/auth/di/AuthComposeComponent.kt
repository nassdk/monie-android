package mon.ie.auth.di

import dagger.Lazy
import dagger.Subcomponent
import mon.ie.auth.presentation.screen.phone.PhoneViewModel
import mon.ie.auth.presentation.screen.pin.PinViewModel
import mon.ie.di.scope.ComposeScope

@ComposeScope
@Subcomponent
internal interface AuthComposeComponent {
    val phoneViewModel: Lazy<PhoneViewModel>
    val pinViewModel: Lazy<PinViewModel>

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComposeComponent
    }
}