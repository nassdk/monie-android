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
    val title: TextStyle,
    val headline: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val body5: TextStyle,
    val button1: TextStyle,
    val button2: TextStyle,
    val textField: TextStyle,
    val caption: TextStyle
)