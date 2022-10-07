package ru.kcenter.navigation.navigator

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import mon.ie.navigation.base.BaseActivity
import mon.ie.navigation.bundle.MessageBundle
import ru.kcenter.navigation.R
import ru.kcenter.navigation.TransitionType
import ru.kcenter.navigation.base.BaseFragment
import ru.kcenter.navigation.command.RequestPermissions
import ru.kcenter.navigation.command.RestartApp
import ru.kcenter.navigation.command.ShowDialog
import ru.kcenter.navigation.command.ShowMessage
import ru.kcenter.navigation.command.SwitchTab
import ru.kcenter.navigation.permissions.PermissionStatus
import ru.kcenter.navigation.screen.DialogScreen


class KCNavigator(
    private val navigatorActivity: BaseActivity,
    containerId: Int,
    fragmentManager: FragmentManager = navigatorActivity.supportFragmentManager,
) : AppNavigator(
    activity = navigatorActivity,
    containerId = containerId,
    fragmentManager = fragmentManager
) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment,
    ) {

        val transitionType = (nextFragment as? BaseFragment)?.transitionType

        if (currentFragment == null || nextFragment == currentFragment) {
            return
        } else when (transitionType) {

            TransitionType.VERTICAL -> {
                fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_bottom,
                    R.anim.slide_out_top,
                    R.anim.slide_in_top,
                    R.anim.slide_out_bottom
                )
            }

            TransitionType.HORIZONTAL -> {
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
            }

            else -> return
        }
    }

    override fun applyCommands(commands: Array<out Command>) {
        handleApplyCommands()
        super.applyCommands(commands)
    }

    override fun applyCommand(command: Command) {
        when (command) {
            is RestartApp -> handleRestartApplicationCommand()
            is ShowDialog -> handleShowDialogCommand(screen = command.screen)
            is SwitchTab -> handleSwitchTabCommand(position = command.position)
            is ShowMessage -> handleShowMessageCommand(bundle = command.messageBundle)
            is RequestPermissions -> handleRequestPermissionsCommand(
                permissions = command.permissions,
                resultListener = command.resultListener
            )
            else -> super.applyCommand(command)
        }
    }

    private fun handleRequestPermissionsCommand(
        permissions: Array<String>,
        resultListener: (List<PermissionStatus>) -> Unit,
    ) {
        navigatorActivity.requestPermission(permissions, resultListener = resultListener)
    }

    private fun handleApplyCommands() {
        navigatorActivity.closeDialog()
        navigatorActivity.clearPermissions()
        navigatorActivity.hideKeyboard()
    }

    private fun handleShowDialogCommand(screen: DialogScreen) {
        val fragment = screen.createFragment(factory = fragmentFactory)
        navigatorActivity.showDialog(fragment = fragment)
    }

    private fun handleShowMessageCommand(bundle: MessageBundle) {
        navigatorActivity.showMessage(bundle = bundle)
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