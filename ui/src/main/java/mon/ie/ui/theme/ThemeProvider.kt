package mon.ie.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import mon.ie.ui.theme.color.MonieColor
import mon.ie.ui.theme.typography.MonieTypography

object MonieTheme {

  val colors: MonieColor
    @Composable
    get() = LocalMonieColors.current

  val typography: MonieTypography
    @Composable
    get() = LocalMonieTypography.current

  val dimens: MonieDimens
    @Composable
    get() = LocalMonieDimens.current

  val shapes: MonieShape
    @Composable
    get() = LocalMonieShapes.current

  val textUnits: MonieTextUnits
    @Composable
    get() = LocalMonieTextUnits.current
}

val LocalMonieColors = staticCompositionLocalOf<MonieColor> {
  error("No colors provided")
}

val LocalMonieTypography = staticCompositionLocalOf<MonieTypography> {
  error("No typography provided")
}

val LocalMonieDimens = staticCompositionLocalOf<MonieDimens> {
  error("No dimens provided")
}

val LocalMonieShapes = staticCompositionLocalOf<MonieShape> {
  error("No shapes provided")
}

val LocalMonieTextUnits = staticCompositionLocalOf<MonieTextUnits> {
  error("No text units provided")
}