package ru.kcenter.navigation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.kcenter.navigation.TransitionType
import ru.kcenter.navigation.router.RouterProvider

abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    open val transitionType: TransitionType = TransitionType.HORIZONTAL

    open fun showNavigationMenu(show: Boolean) {
        (parentFragment as? BaseFragment)?.showNavigationMenu(show = show)
    }

    open fun switchNavigationTab(position: Int) {
        (parentFragment as? BaseFragment)?.switchNavigationTab(position = position)
    }

    protected val tabRouter
        get() = (parentFragment as? RouterProvider)?.router ?: (requireActivity() as RouterProvider).router

    protected open fun setupInjection() = Unit
    protected open fun setupUi() = Unit

    override fun onAttach(context: Context) {
        setupInjection()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupUi()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRealDestroy()) {
            onFinalDestroy()
        }
    }

    abstract fun onBackPressed(): Boolean

    open fun onFinalDestroy() = Unit

    private fun isRealDestroy(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRealRemoving()
        }

    private fun isRealRemoving(): Boolean {
        return (isRemoving) ||
            ((parentFragment as? BaseFragment)?.isRealRemoving() ?: false)
    }
}