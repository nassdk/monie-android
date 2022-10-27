package mon.ie.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import mon.ie.theme.textUnits

internal val typography = MonieTypography(
    t24SemiBold = TextStyle(
        fontSize = textUnits.sp24,
        fontFamily = families,
        fontWeight = FontWeight.SemiBold
    ),
    t20SemiBold = TextStyle(
        fontSize = textUnits.sp20,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    h20Medium = TextStyle(
        fontSize = textUnits.sp20,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    h16Medium = TextStyle(
        fontSize = textUnits.sp16,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    b20Regular = TextStyle(
        fontSize = textUnits.sp20,
        fontFamily = families,
        fontWeight = FontWeight.Normal
    ),
    b18Regular = TextStyle(
        fontSize = textUnits.sp18,
        fontFamily = families,
        fontWeight = FontWeight.Normal
    ),
    b16Regular = TextStyle(
        fontSize = textUnits.sp16,
        fontFamily = families,
        fontWeight = FontWeight.Normal
    ),
    b14Regular = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Normal
    ),
    b12Regular = TextStyle(
        fontSize = textUnits.sp12,
        fontFamily = families,
        fontWeight = FontWeight.Normal
    ),
    b18Medium = TextStyle(
        fontSize = textUnits.sp18,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    b16Medium = TextStyle(
        fontSize = textUnits.sp16,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    b14Medium = TextStyle(
        fontSize = textUnits.sp14,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    ),
    b12Medium = TextStyle(
        fontSize = textUnits.sp12,
        fontFamily = families,
        fontWeight = FontWeight.Medium
    )
)