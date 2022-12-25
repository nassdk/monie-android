package mon.ie.navigation.lifecycle

enum class ComposableLifecycleState {
    CREATED,
    DESTROYED;
}

fun ComposableLifecycleState.isCreated(): Boolean {
    return this == ComposableLifecycleState.CREATED
}