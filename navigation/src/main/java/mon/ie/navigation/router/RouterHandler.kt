package ru.kcenter.navigation.router

import androidx.fragment.app.DialogFragment
import mon.ie.navigation.bundle.MessageBundle
import ru.kcenter.navigation.permissions.PermissionStatus

/**
 * Хендлер для системных действий, которые обрабатываются в активити
 * см. [ru.kcenter.navigation.base.BaseActivity]
 */
interface RouterHandler {
    fun switchNavTab(position: Int)
    fun showMessage(bundle: MessageBundle)
    fun showDialog(fragment: DialogFragment)
    fun closeDialog()
    fun clearPermissions()
    fun requestPermission(
        permissions: Array<String>,
        resultListener: (List<PermissionStatus>) -> Unit,
    )

}