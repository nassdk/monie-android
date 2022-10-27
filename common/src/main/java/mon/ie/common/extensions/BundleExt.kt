package mon.ie.common.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 *
 * @param key - vaue key for Bundle
 *
 * @param T - value type.
 *
 * @return nullable
 * */
inline fun <reified T> Bundle.getValue(key: String): T? {
    return get(key) as? T
}

/**
 * @param default  will be return if
 * @see getValue returns null
 * */
inline fun <reified T> Bundle.getValue(key: String, default: T): T {
    return getValue<T>(key) ?: default
}


/**
 * for non null args
 * */
inline fun <reified T : Any> Bundle.getRequiredValue(key: String): T {
    return requireNotNull(getValue<T>(key)) {
        "No value found by key: $key. Check argument KEY and value type"
    }
}


inline fun <T : Fragment> T.withArgs(
    argsBuilder: Bundle.() -> Unit,
): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }
