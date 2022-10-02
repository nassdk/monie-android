package mon.ie.common.extensions

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

/**
 * Viewmodel create delegate for screen
 *
 * Example:
 *  class SomeScreen {
 *
 *      @Inject
 *      lateinit var viewModelProvider: Provider<SomeViewModel>
 *
 *      override val viewModel by viewModels { viewModelProvider.get() }
 *  }
 */
@MainThread
inline fun <reified VM : ViewModel> Fragment.viewModels(
    crossinline viewModelProducer: () -> VM,
): Lazy<VM> {
    return lazy(LazyThreadSafetyMode.NONE) {
        createViewModel({ viewModelProducer() }, { this.viewModelStore })
    }
}

@MainThread
inline fun <reified VM : ViewModel> Fragment.createViewModel(
    crossinline viewModelProducer: () -> VM,
    crossinline storeProducer: () -> ViewModelStore,
): VM {
    return initViewModel(viewModelProducer, storeProducer)
}

inline fun <reified VM : ViewModel> initViewModel(
    crossinline viewModelProducer: () -> VM,
    crossinline storeProducer: () -> ViewModelStore,
): VM {
    val factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <VM : ViewModel> create(modelClass: Class<VM>) = viewModelProducer() as VM
    }
    val viewModelProvider = ViewModelProvider(storeProducer(), factory)
    return viewModelProvider[VM::class.java]
}