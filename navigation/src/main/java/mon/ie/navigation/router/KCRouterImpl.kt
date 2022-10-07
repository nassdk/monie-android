package ru.kcenter.navigation.router

import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import mon.ie.navigation.bundle.MessageBundle
import ru.kcenter.navigation.command.RequestPermissions
import ru.kcenter.navigation.command.RestartApp
import ru.kcenter.navigation.command.ShowDialog
import ru.kcenter.navigation.command.ShowMessage
import ru.kcenter.navigation.command.SwitchTab
import ru.kcenter.navigation.permissions.PermissionStatus
import ru.kcenter.navigation.screen.DialogScreen
import javax.inject.Inject

@Suppress("SpreadOperator")
class KCRouterImpl @Inject constructor() : KCRouter, Router() {

    override fun requestPermissions(
        permissions: Array<String>,
        resultListener: (List<PermissionStatus>) -> Unit,
    ) {
        executeCommands(
            RequestPermissions(
                permissions = permissions,
                resultListener = resultListener
            )
        )
    }

    override fun showMessage(bundle: MessageBundle) {
        executeCommands(ShowMessage(messageBundle = bundle))
    }

    override fun showDialog(screen: DialogScreen) {
        executeCommands(ShowDialog(screen = screen))
    }

    override fun forward(screen: Screen) {
        executeCommands(Forward(screen))
    }

    override fun setRoot(screen: Screen) {
        executeCommands(BackTo(null), Replace(screen))
    }

    override fun replace(screen: Screen) {
        executeCommands(Replace(screen))
    }

    override fun goBackTo(screen: Screen?) {
        executeCommands(BackTo(screen))
    }

    override fun forwardWithChain(vararg screens: Screen) {
        val commands = screens.map { Forward(it) }
        executeCommands(*commands.toTypedArray())
    }

    override fun setNewRootChain(vararg screens: Screen) {
        val commands = screens.mapIndexed { index, screen ->
            if (index == 0)
                Replace(screen)
            else
                Forward(screen)
        }
        executeCommands(BackTo(null), *commands.toTypedArray())
    }

    override fun resetChain() {
        executeCommands(BackTo(null), Back())
    }

    override fun restartApp() {
        executeCommands(RestartApp())
    }

    override fun switchNavTab(position: Int) {
        executeCommands(SwitchTab(position = position))
    }

    override fun addResultListener(
        key: String,
        listener: ResultListener
    ): ResultListenerHandler {
        return setResultListener(key = key, listener = listener)
    }

    override fun setResult(key: String, data: Any) {
        sendResult(key = key, data = data)
    }

    override fun back() {
        executeCommands(Back())
    }
}