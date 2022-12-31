package mon.ie.common.extensions

import mon.ie.common.delegates.ByNullableDelegate
import kotlin.properties.ReadWriteProperty

inline fun <T> uiLazy(crossinline operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    operation()
}

fun <T> nullable(createFunction: () -> T): ReadWriteProperty<Any?, T> =
    ByNullableDelegate(createFunction)
