package mon.ie.network

import mon.ie.network.di.DaggerNetworkComponent
import mon.ie.network.di.NetworkComponent

object NetworkWrapper {

    private var component: NetworkComponent? = null

    fun getApi(): NetworkApi = getComponent().api()

    internal fun getComponent(): NetworkComponent {
        return component ?: run {
            component = DaggerNetworkComponent.factory().create()

            requireNotNull(component)
        }
    }
}