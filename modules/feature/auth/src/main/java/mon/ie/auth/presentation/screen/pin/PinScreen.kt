package mon.ie.auth.presentation.screen.pin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import mon.ie.theme.MonieDimens
import mon.ie.uikit.components.buttons.MonieButton

@Suppress("UnusedPrivateMember")
@Composable
internal fun PinScreen(navController: NavController, viewModel: PinViewModel) {

    Box(
        modifier = Modifier.fillMaxSize(),
        content = {
            MonieButton(
                modifier = Modifier
                    .padding(all = MonieDimens.dp16)
                    .fillMaxWidth(),
                onClick = {
                    navController.popBackStack()
                },
                builder = {
                    withTitle("Back to phone")
                }
            )
        }
    )
}