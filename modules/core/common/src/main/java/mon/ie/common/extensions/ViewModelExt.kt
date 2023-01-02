package mon.ie.common.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.savedstate.SavedStateRegistryOwner
import mon.ie.common.viewmodel.ViewModelSavedStateFactory

@Composable
inline fun <reified VM : ViewModel> composableAwareViewModel(
    owner: SavedStateRegistryOwner,
    crossinline creator: (SavedStateHandle) -> VM
): VM = viewModel(
    modelClass = VM::class.java,
    factory = ViewModelSavedStateFactory(
        owner = owner,
        viewModelProvider = { savedStateHandle ->
            creator.invoke(savedStateHandle)
        }
    )
)