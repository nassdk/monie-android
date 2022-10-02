package mon.ie.common.base

import mon.ie.common.base.empty.EmptyViewModel

abstract class BaseEmptyScreen : BaseScreen<BaseScreenState, BaseScreenEvent, BaseVmCommand>() {
    override val viewModel = EmptyViewModel.EMPTY
}