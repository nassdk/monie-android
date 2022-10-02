package mon.ie.common.extensions

fun <T> T?.ifNull(alternative: T): T = this ?: alternative