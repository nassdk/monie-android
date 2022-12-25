package mon.ie.common.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class ByNullableDelegate<T>(
    private val createFunction: () -> T
) : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        value ?: createFunction().also(::value::set)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }
}