package mon.ie.uikit.helpers.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mon.ie.theme.MonieTheme

enum class MonieButtonStyle(val backgroundColor: @Composable () -> Color) {

    ACCENT(
        backgroundColor = { MonieTheme.colors.background.purple }
    ),

    PRIMARY(
        backgroundColor = { MonieTheme.colors.background.primary }
    ),

    SECONDARY(
        backgroundColor = { MonieTheme.colors.background.secondary }
    ),

    NONE(
        backgroundColor = { Color.Transparent }
    ),
}