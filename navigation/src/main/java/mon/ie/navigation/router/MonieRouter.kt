package mon.ie.navigation.router

import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Screen
import mon.ie.navigation.screen.DialogScreen

/**
 * Wrapper over [com.github.terrakok.cicerone.Router]
 */
interface MonieRouter {
  fun addResultListener(key: String, listener: ResultListener): ResultListenerHandler
  fun setResult(key: String, data: Any)
  fun switchNavTab(position: Int)
  fun showDialog(screen: DialogScreen)
  fun forward(screen: Screen)
  fun setRoot(screen: Screen)
  fun replace(screen: Screen)
  fun goBackTo(screen: Screen?)
  fun forwardWithChain(vararg screens: Screen)
  fun setNewRootChain(vararg screens: Screen)
  fun resetChain()
  fun restartApp()
  fun back()
}