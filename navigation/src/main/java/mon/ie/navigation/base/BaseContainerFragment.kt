package ru.kcenter.navigation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.strictmode.FragmentStrictMode
import com.github.terrakok.cicerone.Cicerone
import mon.ie.navigation.base.BaseActivity
import ru.kcenter.navigation.BuildConfig
import ru.kcenter.navigation.navigator.KCNavigator
import ru.kcenter.navigation.router.KCRouter
import ru.kcenter.navigation.router.KCRouterImpl
import ru.kcenter.navigation.router.RouterProvider

abstract class BaseContainerFragment(@LayoutRes layoutResId: Int) : BaseFragment(
    layoutResId = layoutResId
), RouterProvider {

    override val router: KCRouter
        get() = cicerone.router

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        KCNavigator(
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

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(containerResId)
        return fragment != null && fragment is BaseFragment && fragment.onBackPressed()
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

    abstract val cicerone: Cicerone<KCRouterImpl>
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