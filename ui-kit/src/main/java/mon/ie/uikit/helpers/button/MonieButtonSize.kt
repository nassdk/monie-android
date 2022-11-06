package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import mon.ie.theme.MonieTheme

enum class MonieButtonSize(
  val buttonHeight: @Composable () -> Dp,
  val textSize: @Composable () -> TextUnit,
  val progressIndicatorSize: @Composable () -> Dp
) {

  LARGE(
    buttonHeight = { 44.dp },
    textSize = { MonieTheme.textUnits.sp14 },
    progressIndicatorSize = { 20.dp }
  ),

  SMALL(
    buttonHeight = { 32.dp },
    textSize = { MonieTheme.textUnits.sp12 },
    progressIndicatorSize = { 14.dp }
  ),
}