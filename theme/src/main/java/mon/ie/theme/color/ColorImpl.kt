package mon.ie.theme.color

//TODO to be updated by stable design system.

internal fun currentPalette(isDark: Boolean): MonieColor {
    return if (isDark) DarkPalette else LightPalette
}

internal val DarkPalette = MonieColor(
    background = MonieColorBackground(
        primary = White,
        secondary = Gray5D6A75,
        purple = Purple,
        border = Gray9685FF,
        darkTransaprent = GrayEBEDEE
    ),
    text = MonieColorText(
        primary = Black,
        secondary = GrayADB4B9,
        red = Red,
        purple = Purple,
        disabled = PurpleOpacity50
    )
)

internal val LightPalette = MonieColor(
    background = MonieColorBackground(
        primary = White,
        secondary = WhiteF5F6F7,
        border = Gray9685FF,
        purple = Purple,
        darkTransaprent = GrayEBEDEE
    ),
    text = MonieColorText(
        primary = Black,
        secondary = GrayADB4B9,
        red = Red,
        purple = Purple,
        disabled = PurpleOpacity50
    )
)