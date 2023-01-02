package mon.ie.common.base

data class IESideEffect(val isTriggered: Boolean) {
    companion object {
        fun IESideEffect.consumed(): IESideEffect = IESideEffect(isTriggered = false)
        fun IESideEffect.triggered(): IESideEffect = IESideEffect(isTriggered = true)
        fun initial(): IESideEffect = IESideEffect(isTriggered = false)
    }
}