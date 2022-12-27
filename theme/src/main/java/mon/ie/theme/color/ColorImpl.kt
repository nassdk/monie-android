package mon.ie.theme.color

internal fun currentPalette(isDark: Boolean): MonieColor {
    return if (isDark) DarkPalette else LightPalette
}

internal val LightPalette = MonieColor(
    background = White,
    separator = WhiteEBEDEE,
    text = MonieTextColor(
        primary = Black011627,
        secondary = Gray5C6A75
    ),
    interactive = MonieInteractiveColor(
        primary = Purple,
        secondary = WhiteF5F6F7,
        tertiary = Black1F3241,
        gradient = Purple71569C to Purple7662F6
    ),
    default = MonieDefaultColor(
        red = Red
    )
)


internal val DarkPalette = MonieColor(
    background = Black,
    separator = Black1F3241,
    text = MonieTextColor(
        primary = White,
        secondary = GrayAEB4BA
    ),
    interactive = MonieInteractiveColor(
        primary = Purple,
        secondary = Black011627,
        tertiary = White,
        gradient = Purple71569C to Purple7662F6,
    ),
    default = MonieDefaultColor(
        red = Red
    )
)