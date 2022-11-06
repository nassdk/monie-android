package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mon.ie.theme.MonieTheme

enum class MonieButtonStyle(
  val backgroundColor: @Composable () -> Color,
  val textColor: @Composable () -> Color
) {

  ACCENT(
    backgroundColor = { MonieTheme.colors.background.purple },
    textColor = { Color.White }
  ),

  SECONDARY(
    backgroundColor = { MonieTheme.colors.background.secondary },
    textColor = { MonieTheme.colors.text.primary }
  )
}