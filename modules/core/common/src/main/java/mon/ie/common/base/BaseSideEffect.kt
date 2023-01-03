package mon.ie.common.base

data class BaseSideEffect(val isTriggered: Boolean) {
    companion object {
        fun BaseSideEffect.consumed(): BaseSideEffect = BaseSideEffect(isTriggered = false)
        fun BaseSideEffect.triggered(): BaseSideEffect = BaseSideEffect(isTriggered = true)
        fun initial(): BaseSideEffect = BaseSideEffect(isTriggered = false)
    }
}