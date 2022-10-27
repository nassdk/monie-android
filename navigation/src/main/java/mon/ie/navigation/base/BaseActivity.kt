package mon.ie.navigation.base

import android.os.Bundle
import android.os.StrictMode
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.strictmode.FragmentStrictMode
import mon.ie.navigation.BuildConfig
import mon.ie.navigation.router.RouterHandler
import mon.ie.navigation.router.RouterProvider

abstract class BaseActivity(@LayoutRes layoutRes: Int) : AppCompatActivity(layoutRes),
    RouterHandler, RouterProvider {

    private var currentDialogTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            setupStrictMode()
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
        super.onDestroy()
    }

    private companion object {
        private const val MILLIS_DIVIDER = 1234321
    }
}