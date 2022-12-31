package mon.ie.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import mon.ie.theme.color.currentPalette
import mon.ie.theme.typography.typography

@Composable
fun MonieTheme(
    isSystemDark: Boolean,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalMonieColors provides currentPalette(isDark = isSystemDark),
        LocalMonieDimens provides dimens,
        LocalMonieShapes provides shapes,
        LocalMonieTextUnits provides textUnits,
        LocalMonieTypography provides typography,
        content = content
    )
}