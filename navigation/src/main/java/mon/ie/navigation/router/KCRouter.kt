package ru.kcenter.navigation.router

import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Screen
import mon.ie.navigation.bundle.MessageBundle
import ru.kcenter.navigation.permissions.PermissionStatus
import ru.kcenter.navigation.screen.DialogScreen

/**
 * Обертка над [com.github.terrakok.cicerone.Router]
 */
interface KCRouter {

    fun requestPermissions(
        permissions: Array<String>,
        resultListener: (List<PermissionStatus>) -> Unit,
    )

    fun addResultListener(key: String, listener: ResultListener): ResultListenerHandler
    fun setResult(key: String, data: Any)
    fun switchNavTab(position: Int)
    fun showMessage(bundle: MessageBundle)
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