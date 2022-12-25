package mon.ie.common.delegates

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import mon.ie.di.ViewModelProviderFactory

fun <T> ViewModelStoreOwner.scopedComponent(componentProvider: () -> T): Lazy<T> =
    ScopedComponentDelegate(this, componentProvider)

private class ScopedComponentDelegate<T>(
    private val storeOwner: ViewModelStoreOwner,
    private val componentProvider: () -> T,
) : Lazy<T> {

    private var cached: T? = null

    override val value: T
        get() {
            val component = cached
            if (component != null) return component

            val viewModelProvider = ViewModelProvider(
                owner = storeOwner,
                factory = ViewModelProviderFactory {
                    ScopedComponentHolder(componentProvider())
                }
            )

            val componentHolder = viewModelProvider[ScopedComponentHolder::class.java]

            @Suppress("UNCHECKED_CAST")
            return (componentHolder.component as T).also { cached = it }
        }

    override fun isInitialized(): Boolean = cached != null
}