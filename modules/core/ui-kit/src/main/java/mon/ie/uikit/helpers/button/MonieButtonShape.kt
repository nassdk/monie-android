package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import mon.ie.theme.MonieShapes

/**
 * Button shapes
 */
enum class MonieButtonShape(val value: @Composable () -> Shape) {
    LARGE(value = { MonieShapes.mediumShape }),
    SMALL(value = { MonieShapes.smallShape }),
    TOPPED(value = { MonieShapes.toppedMedium }),
    BOTTOMED(value = { MonieShapes.bottomedMedium }),
    NONE(value = { MonieShapes.empty })
}