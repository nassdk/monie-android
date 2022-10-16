package mon.ie.common.base.empty

import mon.ie.common.base.BaseScreenEvent
import mon.ie.common.base.BaseViewModel
import mon.ie.common.base.BaseVmCommand

class EmptyViewModel private constructor() : BaseViewModel<EmptyScreenState, BaseScreenEvent, BaseVmCommand>() {
  override val initialState = EmptyScreenState()

  internal companion object {
    val INSTANCE = EmptyViewModel()
  }
}