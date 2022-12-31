package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mon.ie.theme.MonieColors

enum class MonieButtonStyle(val backgroundColor: @Composable () -> Color) {

    ACCENT(
        backgroundColor = { MonieColors.interactive.primary }
    ),

    SECONDARY(
        backgroundColor = { MonieColors.interactive.secondary }
    ),

    NONE(
        backgroundColor = { Color.Transparent }
    )
}