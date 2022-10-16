package mon.ie.navigation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.strictmode.FragmentStrictMode
import com.github.terrakok.cicerone.Cicerone
import mon.ie.navigation.BuildConfig
import mon.ie.navigation.navigator.MonieNavigator
import mon.ie.navigation.router.MonieRouter
import mon.ie.navigation.router.MonieRouterImpl
import mon.ie.navigation.router.RouterProvider

abstract class BaseContainerFragment(@LayoutRes layoutResId: Int) : BaseFragment(), RouterProvider {

  override val router: MonieRouter
    get() = cicerone.router

  private val navigator by lazy(LazyThreadSafetyMode.NONE) {
    MonieNavigator(
      navigatorActivity = requireActivity() as BaseActivity,
      containerId = containerResId,
      fragmentManager = childFragmentManager
    )
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)

    if (BuildConfig.DEBUG) {
      setupStrictMode()
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    if (childFragmentManager.findFragmentById(containerResId) == null) {
      executeTransactions()
    }
  }

  override fun onResume() {
    super.onResume()
    cicerone.getNavigatorHolder().setNavigator(navigator)
  }

  override fun onPause() {
    cicerone.getNavigatorHolder().removeNavigator()
    super.onPause()
  }

  abstract val cicerone: Cicerone<MonieRouterImpl>
  abstract val containerResId: Int

  abstract fun executeTransactions()

  open fun resetStack() {
    router.goBackTo(null)
  }

  private fun setupStrictMode() {

    childFragmentManager.strictModePolicy = FragmentStrictMode.Policy.Builder()
      .penaltyDeath()
      .detectFragmentReuse()
      .detectFragmentTagUsage()
      .detectWrongFragmentContainer()
      .build()
  }
}