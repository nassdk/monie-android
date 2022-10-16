package mon.ie.navigation.base

import android.content.Context
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import mon.ie.navigation.router.RouterProvider

abstract class BaseFragment : Fragment() {

  override fun onAttach(context: Context) {
    super.onAttach(context)

    requireActivity().onBackPressedDispatcher.addCallback(
      this,
      object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
          if (isEnabled && onBackPressed()) {
            isEnabled = false
            requireActivity().onBackPressedDispatcher.onBackPressed()
          }
        }
      }
    )
  }

  open fun showNavigationMenu(show: Boolean) {
    (parentFragment as? BaseFragment)?.showNavigationMenu(show = show)
  }

  open fun switchNavigationTab(position: Int) {
    (parentFragment as? BaseFragment)?.switchNavigationTab(position = position)
  }

  protected val tabRouter
    get() = (parentFragment as? RouterProvider)?.router ?: (requireActivity() as RouterProvider).router

  /**
   * if returns true, onbackpressed will be dispatched,
   * otherwise won't
   */
  protected open fun onBackPressed(): Boolean {
    return true
  }
}