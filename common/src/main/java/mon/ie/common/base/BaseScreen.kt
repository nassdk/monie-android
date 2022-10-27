package mon.ie.common.base

import mon.ie.common.base.empty.EmptyScreenState
import mon.ie.common.base.empty.EmptyViewModel

abstract class BaseScreen : BaseVmScreen<EmptyScreenState, BaseScreenEvent, BaseVmCommand>() {
    override val viewModel = EmptyViewModel.INSTANCE
}