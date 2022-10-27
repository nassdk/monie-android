package mon.ie.navigation.navigator

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import mon.ie.navigation.base.BaseActivity
import mon.ie.navigation.command.RestartApp
import mon.ie.navigation.command.ShowDialog
import mon.ie.navigation.command.SwitchTab
import mon.ie.navigation.screen.DialogScreen

class MonieNavigator(
    private val navigatorActivity: BaseActivity,
    containerId: Int,
    fragmentManager: FragmentManager = navigatorActivity.supportFragmentManager,
) : AppNavigator(
    activity = navigatorActivity,
    containerId = containerId,
    fragmentManager = fragmentManager
) {

    override fun applyCommands(commands: Array<out Command>) {
        handleApplyCommands()
        super.applyCommands(commands)
    }

    override fun applyCommand(command: Command) {
        when (command) {
            is RestartApp -> handleRestartApplicationCommand()
            is ShowDialog -> handleShowDialogCommand(screen = command.screen)
            is SwitchTab -> handleSwitchTabCommand(position = command.position)
            else -> super.applyCommand(command)
        }
    }

    private fun handleApplyCommands() {
        navigatorActivity.closeDialog()
        navigatorActivity.hideKeyboard()
    }

    private fun handleShowDialogCommand(screen: DialogScreen) {
        val fragment = screen.createFragment(factory = fragmentFactory)
        navigatorActivity.showDialog(fragment = fragment)
    }

    private fun handleSwitchTabCommand(position: Int) {
        navigatorActivity.switchNavTab(position = position)
    }

    private fun handleRestartApplicationCommand() {

        with(navigatorActivity) {
            baseContext.packageManager
                .getLaunchIntentForPackage(packageName)
                ?.apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }?.also(::startActivity)
        }
    }

    private fun FragmentActivity.hideKeyboard(flags: Int = 0) {
        val view = currentFocus ?: View(this)
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, flags)
    }
}