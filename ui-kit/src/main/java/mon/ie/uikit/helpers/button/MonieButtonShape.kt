package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import mon.ie.theme.MonieTheme

/**
 * Button shapes
 */
enum class MonieButtonShape(val value: @Composable () -> Shape) {
  LARGE(value = { MonieTheme.shapes.mediumShape }),
  SMALL(value = { MonieTheme.shapes.smallShape }),
  TOPPED(value = { MonieTheme.shapes.toppedMedium }),
  BOTTOMED(value = { MonieTheme.shapes.bottomedMedium })
}