package mon.ie.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import mon.ie.theme.R

internal val families = FontFamily(
    Font(resId = R.font.rubik_300, weight = FontWeight(weight = 300)),
    Font(resId = R.font.rubik_400, weight = FontWeight(weight = 400)),
    Font(resId = R.font.rubik_500, weight = FontWeight(weight = 500)),
    Font(resId = R.font.rubik_600, weight = FontWeight(weight = 600)),
    Font(resId = R.font.rubik_700, weight = FontWeight(weight = 700)),
    Font(resId = R.font.rubik_800, weight = FontWeight(weight = 800)),
    Font(resId = R.font.rubik_900, weight = FontWeight(weight = 900)),
)

class MonieTypography internal constructor(
    val t24SemiBold: TextStyle,
    val t20SemiBold: TextStyle,
    val h20Medium: TextStyle,
    val h16Medium: TextStyle,
    val b20Regular: TextStyle,
    val b18Regular: TextStyle,
    val b16Regular: TextStyle,
    val b14Regular: TextStyle,
    val b12Regular: TextStyle,
    val b18Medium: TextStyle,
    val b16Medium: TextStyle,
    val b14Medium: TextStyle,
    val b12Medium: TextStyle
)