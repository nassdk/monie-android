package mon.ie.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope

abstract class BaseScreen<
    STATE : BaseScreenState,
    EVENT : BaseScreenEvent,
    COMMAND : BaseVmCommand
    > : Fragment() {

    abstract val viewModel: BaseViewModel<STATE, EVENT, COMMAND>

    @Composable
    abstract fun ScreenContent(screenState: STATE)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupInjection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupInjection()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(context = requireContext()).apply {

        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )

        setContent(
            content = {
                MaterialTheme(
                    content = { ScreenContent(screenState = viewModel.screenState.collectAsState().value) }
                )
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.commands.flowWithLifecycle(lifecycle = lifecycle).collect(::handleVmCommand)
        }
    }

    protected open fun setupInjection() = Unit
    protected open fun handleVmCommand(command: COMMAND) = Unit
}