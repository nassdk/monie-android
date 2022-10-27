package mon.ie.common.extensions

import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(windowFlags: Int = 0) {

    val currentFocus = requireActivity().currentFocus ?: return
    ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
        ?.hideSoftInputFromWindow(currentFocus.windowToken, windowFlags)
}