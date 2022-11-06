package mon.ie.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

//TODO to be updated by stable design system

class MonieShape internal constructor(
    val smallShape: Shape,
    val mediumShape: Shape,
    val largeShape: Shape,
  val bottomedMedium: Shape,
  val toppedMedium: Shape
)

internal val shapes = MonieShape(
    smallShape = RoundedCornerShape(size = dimens.dp8),
  mediumShape = RoundedCornerShape(size = dimens.dp12),
  largeShape = RoundedCornerShape(size = dimens.dp16),
  bottomedMedium = RoundedCornerShape(
    bottomStart = dimens.dp12,
    bottomEnd = dimens.dp12,
    topStart = 0.dp,
    topEnd = 0.dp
  ),
  toppedMedium = RoundedCornerShape(
    topStart = dimens.dp12,
    topEnd = dimens.dp12,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
  )
)