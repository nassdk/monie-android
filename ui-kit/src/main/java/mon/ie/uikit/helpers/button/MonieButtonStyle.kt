package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mon.ie.theme.MonieColors

enum class MonieButtonStyle(val backgroundColor: @Composable () -> Color) {

    ACCENT(
        backgroundColor = { MonieColors.background.purple }
    ),

    PRIMARY(
        backgroundColor = { MonieColors.background.primary }
    ),

    SECONDARY(
        backgroundColor = { MonieColors.background.secondary }
    ),

    NONE(
        backgroundColor = { Color.Transparent }
    ),
}