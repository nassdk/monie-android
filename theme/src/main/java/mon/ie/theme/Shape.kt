package mon.ie.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape

//TODO to be updated by stable design system

class MonieShape internal constructor(
  val minShape: Shape,
  val mediumShape: Shape,
  val largeShape: Shape
)

internal val shapes = MonieShape(
  minShape = RoundedCornerShape(size = dimens.dp8),
  mediumShape = RoundedCornerShape(size = dimens.dp12),
  largeShape = RoundedCornerShape(size = dimens.dp16),
)