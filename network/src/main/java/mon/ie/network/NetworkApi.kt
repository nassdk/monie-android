package mon.ie.network

interface NetworkApi {

    /**
     * Provides retrofit instance based on specific interface for Features.
     */
    fun <T> provideApiClass(interfaceClass: Class<T>): T
}