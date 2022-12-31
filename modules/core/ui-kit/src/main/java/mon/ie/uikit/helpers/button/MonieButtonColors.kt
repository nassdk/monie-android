package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

@Immutable
data class MonieButtonColors(
  val backgroundColor: Color,
  val disabledBackgroundColor: Color = backgroundColor.copy(alpha = 0.5f)
) {
  @Composable
  fun backgroundColor(isEnabled: Boolean): State<Color> {
    return rememberUpdatedState(
      if (isEnabled) {
        backgroundColor
      } else {
        disabledBackgroundColor
      }
    )
  }
}