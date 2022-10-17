package mon.ie.theme

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class MonieTextUnits internal constructor(
  val sp12: TextUnit = 12.sp,
  val sp14: TextUnit = 14.sp,
  val sp16: TextUnit = 16.sp,
  val sp18: TextUnit = 18.sp,
  val sp20: TextUnit = 20.sp,
  val sp24: TextUnit = 24.sp
)

internal val textUnits = MonieTextUnits()