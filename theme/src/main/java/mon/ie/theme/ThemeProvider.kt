package mon.ie.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import mon.ie.theme.color.MonieColor
import mon.ie.theme.typography.MonieTypography

val MonieColors
    @Composable
    get() = LocalMonieColors.current

val MonieTypograhy
    @Composable
    get() = LocalMonieTypography.current

val MonieDimens
    @Composable
    get() = LocalMonieDimens.current

val MonieShapes
    @Composable
    get() = LocalMonieShapes.current

val MonieTextUnits
    @Composable
    get() = LocalMonieTextUnits.current

internal val LocalMonieColors = staticCompositionLocalOf<MonieColor> {
    error("No colors provided")
}

internal val LocalMonieTypography = staticCompositionLocalOf<MonieTypography> {
    error("No typography provided")
}

internal val LocalMonieDimens = staticCompositionLocalOf<MonieDimen> {
    error("No dimens provided")
}

internal val LocalMonieShapes = staticCompositionLocalOf<MonieShape> {
    error("No shapes provided")
}

internal val LocalMonieTextUnits = staticCompositionLocalOf<MonieTextUnit> {
    error("No text units provided")
}