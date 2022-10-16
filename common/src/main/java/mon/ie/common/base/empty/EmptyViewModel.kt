package mon.ie.common.base.empty

import mon.ie.common.base.BaseScreenEvent
import mon.ie.common.base.BaseScreenState
import mon.ie.common.base.BaseViewModel
import mon.ie.common.base.BaseVmCommand

class EmptyViewModel private constructor() : BaseViewModel<BaseScreenState, BaseScreenEvent, BaseVmCommand>() {
    override val initialState = BaseScreenState.EMPTY

    internal companion object {
        val INSTANCE = EmptyViewModel()
    }
}