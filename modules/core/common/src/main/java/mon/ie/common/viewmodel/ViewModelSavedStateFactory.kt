package mon.ie.common.viewmodel

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class ViewModelSavedStateFactory<VM : ViewModel>(
    owner: SavedStateRegistryOwner,
    private val viewModelProvider: (SavedStateHandle) -> VM
) : AbstractSavedStateViewModelFactory(owner, null) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = viewModelProvider.invoke(handle) as T
}
