package mon.ie.common.extensions

fun <T> List<T>.firstAndDo(block: (T) -> Unit) {
    if (isNotEmpty()) {
        block.invoke(first())
    }
}

fun <T> List<T>.indexOfFirstOrNull(element: T): Int? {
    for (index in indices) {
        if (element == this[index]) {
            return index
        }
    }

    return null
}

inline fun <reified T> List<Any>.findByType(
    condition: (T) -> Boolean = { true }
): T? {
    return find { it is T && condition(it) } as? T
}

inline fun <reified T> List<Any>.indexOfType(): Int {
    for ((index, item) in this.withIndex()) {
        if (item is T) return index
    }
    return -1
}