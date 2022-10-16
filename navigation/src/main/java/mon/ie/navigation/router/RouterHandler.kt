package mon.ie.navigation.router

import androidx.fragment.app.DialogFragment

/**
 * Хендлер для системных действий, которые обрабатываются в активити
 * см. [mon.ie.navigation.base.BaseActivity]
 */
interface RouterHandler {
  fun switchNavTab(position: Int)
  fun showDialog(fragment: DialogFragment)
  fun showBottomScreen()
  fun closeDialog()
}