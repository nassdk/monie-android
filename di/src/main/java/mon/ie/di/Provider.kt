package mon.ie.di

fun interface Provider<T> {
    operator fun invoke(): T
}