package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class MonieButtonSize(
  val buttonHeight: @Composable () -> Dp,
  val progressIndicatorSize: @Composable () -> Dp
) {

  LARGE(
    buttonHeight = { 44.dp },
    progressIndicatorSize = { 20.dp }
  ),

  SMALL(
    buttonHeight = { 32.dp },
    progressIndicatorSize = { 14.dp }
  ),
}