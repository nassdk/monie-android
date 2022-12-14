package mon.ie.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import mon.ie.theme.textUnits

internal val typography = MonieTypography(
    title = TextStyle(
        fontSize = textUnits.sp20,
        fontFamily = families,
        fontWeight = FontWeight.SemiBold,
        lineHeight = textUnits.sp24
    ),
    headline = TextStyle(
        fontSize = textUnits.sp20,
        fontFamily = families,
        fontWeight = FontWeight.Medium,
        lineHeight = textUnits.sp20
    ),
    body1 = TextStyle(
        fontSize = textUnits.sp16,
        fontFamily = families,
        fontWeight = FontWeight.Normal,
        lineHeight = textUnits.sp20
    ),
    body2 = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Medium,
        lineHeight = textUnits.sp18
    ),
    body3 = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Normal,
        lineHeight = textUnits.sp18
    ),
    body4 = TextStyle(
        fontSize = textUnits.sp12,
        fontFamily = families,
        fontWeight = FontWeight.Medium,
        lineHeight = textUnits.sp16
    ),
    body5 = TextStyle(
        fontSize = textUnits.sp12,
        fontFamily = families,
        fontWeight = FontWeight.Normal,
        lineHeight = textUnits.sp16
    ),
    button1 = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Normal,
        lineHeight = textUnits.sp18
    ),
    button2 = TextStyle(
        fontSize = textUnits.sp12,
        fontFamily = families,
        fontWeight = FontWeight.Normal,
        lineHeight = textUnits.sp16
    ),
    textField = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Medium,
        lineHeight = textUnits.sp18
    ),
    caption = TextStyle(
        fontSize = textUnits.sp10,
        fontFamily = families,
        fontWeight = FontWeight.Medium,
        lineHeight = textUnits.sp14
    )
)