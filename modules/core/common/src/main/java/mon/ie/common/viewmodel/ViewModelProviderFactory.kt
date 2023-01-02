package mon.ie.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mon.ie.di.Provider

class ViewModelProviderFactory<VM : ViewModel>(
    private val viewModelProvider: Provider<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProvider.invoke() as T
    }
}