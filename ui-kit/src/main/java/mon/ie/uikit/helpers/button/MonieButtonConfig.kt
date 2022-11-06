package mon.ie.uikit.helpers.button

import mon.ie.uikit.helpers.button.MonieButtonSize.SMALL

class MonieButtonConfig(
  val items: List<MonieButtonItem>,
  val size: MonieButtonSize,
  val shape: MonieButtonShape,
  val style: MonieButtonStyle
) {
  val hasStartIcon: Boolean
    get() = items.any { it is MonieButtonItem.StartIcon }

  val hasEndIcon: Boolean
    get() = items.any { it is MonieButtonItem.EndIcon }

  val isSmall: Boolean
    get() = size == SMALL
}