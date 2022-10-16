package mon.ie.ui.theme.color

//TODO to be updated by stable design system.

internal fun currentPalette(isDark: Boolean): MonieColor {
  return if (isDark) DarkPalette else LightPalette
}

internal val DarkPalette = MonieColor(
  background = MonieColorBackground(
    primary = White,
    secondary = WhiteF5F6F7
  ),
  text = MonieColorText(
    primary = Black,
    secondary = GrayADB4B9
  ),
  button = MonieColorButton(
    primary = Purple,
    secondary = WhiteF5F6F7,
    disabled = PurpleOpacity50
  )
)

internal val LightPalette = MonieColor(
  background = MonieColorBackground(
    primary = White,
    secondary = WhiteF5F6F7
  ),
  text = MonieColorText(
    primary = Black,
    secondary = GrayADB4B9
  ),
  button = MonieColorButton(
    primary = Purple,
    secondary = WhiteF5F6F7,
    disabled = PurpleOpacity50
  )
)