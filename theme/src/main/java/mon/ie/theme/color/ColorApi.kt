@file:Suppress("MagicNumber")

package mon.ie.theme.color

import androidx.compose.ui.graphics.Color

class MonieColor internal constructor(
    val background: Color,
    val separator: Color,
    val text: MonieTextColor,
    val interactive: MonieInteractiveColor,
    val default: MonieDefaultColor
)

class MonieTextColor internal constructor(
    val primary: Color,
    val secondary: Color
)

class MonieInteractiveColor internal constructor(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val gradient: Pair<Color, Color>
)

class MonieDefaultColor internal constructor(val red: Color)

internal val White = Color(0xFFFFFFFF)
internal val WhiteF5F6F7 = Color(0xFFF5F6F7)
internal val WhiteEBEDEE = Color(0xFFEBEDEE)

internal val Black = Color(0xFF00060A)
internal val Black011627 = Color(0xFF011627)
internal val Black1F3241 = Color(0xFF1F3241)

internal val Gray5C6A75 = Color(0xFF5C6A75)
internal val GrayAEB4BA = Color(0xFFAEB4BA)

internal val Purple = Color(0xFF7662F5)
internal val Purple71569C = Color(0xFF71569C)
internal val Purple7662F6 = Color(0xFF7662F6)

internal val Red = Color(0xFFCC2936)

