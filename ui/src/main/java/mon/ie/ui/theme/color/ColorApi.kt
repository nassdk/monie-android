package mon.ie.ui.theme.color

import androidx.compose.ui.graphics.Color

//TODO to be updated by stable design system.

class MonieColor internal constructor(
  val background: MonieColorBackground,
  val text: MonieColorText,
  val button: MonieColorButton
)

class MonieColorBackground internal constructor(val primary: Color, val secondary: Color)

class MonieColorText internal constructor(val primary: Color, val secondary: Color)

class MonieColorButton internal constructor(
  val primary: Color,
  val secondary: Color,
  val disabled: Color
)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF203241)
val Red = Color(0xFFCC2936)
val WhiteF5F6F7 = Color(0xFFF5F6F7)
val GrayADB4B9 = Color(0xFFADB4B9)
val Purple = Color(0xFF7662F5)
val PurpleOpacity50 = Color(0x807662F5)

