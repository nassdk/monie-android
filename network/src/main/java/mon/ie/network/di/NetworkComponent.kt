package mon.ie.network.di

import dagger.Component
import mon.ie.network.NetworkApi
import mon.ie.network.NetworkApiImpl
import javax.inject.Scope

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