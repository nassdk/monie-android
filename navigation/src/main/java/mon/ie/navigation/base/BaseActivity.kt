package mon.ie.navigation.base

import android.os.Bundle
import android.os.StrictMode
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.strictmode.FragmentStrictMode
import ru.kcenter.navigation.BuildConfig
import ru.kcenter.navigation.R
import ru.kcenter.navigation.permissions.PermissionStatus
import ru.kcenter.navigation.router.RouterHandler
import ru.kcenter.navigation.router.RouterProvider

abstract class BaseActivity(@LayoutRes layoutRes: Int) : AppCompatActivity(layoutRes), RouterHandler, RouterProvider {

    private var currentDialogTag: String? = null
    private var permissionResultCallback: ((List<PermissionStatus>) -> Unit)? = null

    private val permissionResult = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions -> checkPermissions(permissions = permissions) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null)
            updateAppTheme()

        if (BuildConfig.DEBUG) {
            setupStrictMode()
        }
    }


    private fun updateAppTheme() {

        window.apply {
            decorView.setBackgroundColor(ContextCompat.getColor(context, R.color.ui_primary_white))
            statusBarColor = ContextCompat.getColor(context, R.color.ui_primary_white)
            navigationBarColor = ContextCompat.getColor(context, R.color.ui_primary_white)


            var flags = decorView.systemUiVisibility
            flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            decorView.systemUiVisibility = flags
        }
    }

    override fun showDialog(fragment: DialogFragment) {

        val tag = buildString {
            append(fragment::class.java.simpleName)
            append(System.currentTimeMillis() / MILLIS_DIVIDER)
        }

        currentDialogTag = tag

        fragment.show(supportFragmentManager, tag)
    }

    override fun closeDialog() {

        currentDialogTag ?: return

        val fragment = supportFragmentManager.findFragmentByTag(currentDialogTag) ?: run {
            currentDialogTag = null
            return
        }

        currentDialogTag = null

        if (fragment is DialogFragment) {
            fragment.dismiss()
        }
    }

    override fun requestPermission(
        permissions: Array<String>,
        resultListener: (List<PermissionStatus>) -> Unit,
    ) {
        permissionResultCallback = resultListener
        permissionResult.launch(permissions)
    }

    override fun clearPermissions() {
        permissionResultCallback = null
    }

    private fun checkPermissions(permissions: MutableMap<String, Boolean>) {

        val status = permissions.entries.map { (name, isGranted) ->
            when {
                isGranted -> PermissionStatus.Granted
                shouldShowRequestPermissionRationale(name) -> PermissionStatus.ShowRationale(
                    permissionName = name
                )
                else -> PermissionStatus.Denied(permissionName = name)
            }
        }
        permissionResultCallback?.invoke(status)
        permissionResultCallback = null
    }

    private fun setupStrictMode() {

        supportFragmentManager.strictModePolicy = FragmentStrictMode.Policy.Builder()
            .detectFragmentReuse()
            .detectFragmentTagUsage()
            .detectWrongFragmentContainer()
            .penaltyDeath()
            .build()

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectCustomSlowCalls()
                .detectNetwork()
                .penaltyDialog()
                .build()
        )
    }

    override fun onDestroy() {
        closeDialog()
        permissionResult.unregister()
        permissionResultCallback = null
        super.onDestroy()
    }

    private companion object {
        private const val MILLIS_DIVIDER = 1234321
    }
}