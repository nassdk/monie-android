package mon.ie.theme.color

import androidx.compose.ui.graphics.Color

//TODO to be updated by stable design system.

class MonieColor internal constructor(
    val background: MonieColorBackground,
    val text: MonieColorText
)

class MonieColorBackground internal constructor(
    val primary: Color,
    val secondary: Color,
    val purple: Color,
  val border: Color
)

class MonieColorText internal constructor(
    val primary: Color,
    val secondary: Color,
    val disabled: Color,
    val red: Color,
    val purple: Color
)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF203241)
val Red = Color(0xFFCC2936)
val WhiteF5F6F7 = Color(0xFFF5F6F7)
val GrayADB4B9 = Color(0xFFADB4B9)
val Purple = Color(0xFF7662F5)
val PurpleOpacity50 = Color(0x807662F5)
val Gray9685FF = Color(0x009685FF)
val Gray5D6A75 = Color(0x005D6A75)
val GrayEBEDEE = Color(0x0EBEDEE)

