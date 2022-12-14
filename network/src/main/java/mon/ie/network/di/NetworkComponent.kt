package mon.ie.network.di

import dagger.Component
import javax.inject.Scope
import mon.ie.network.NetworkApi
import mon.ie.network.NetworkApiImpl

@Scope
annotation class NetworkScope

@NetworkScope
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }

    fun inject(into: NetworkApiImpl)

    fun api(): NetworkApi
}