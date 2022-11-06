package mon.ie.uikit.helpers.button

import mon.ie.uikit.helpers.button.MonieButtonItem.EndIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.StartIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.Title
import mon.ie.uikit.helpers.button.MonieButtonSize.LARGE
import mon.ie.uikit.helpers.button.MonieButtonStyle.ACCENT
import kotlin.LazyThreadSafetyMode.NONE

class MonieButtonBuilderImpl : MonieButtonBuilder {

  private val items by lazy(NONE) {
    ArrayList<MonieButtonItem>(3)
  }

  private var size: MonieButtonSize? = null
  private var shape: MonieButtonShape? = null
  private var style: MonieButtonStyle? = null

  override fun withStartIcon(iconRes: Int) {
    items.removeIf { it is StartIcon }
    items.add(0, StartIcon(icon = iconRes))
  }

  override fun withEndIcon(iconRes: Int) {
    items.removeIf { it is EndIcon }
    items.add(EndIcon(icon = iconRes))
  }

  override fun withSize(size: MonieButtonSize) {
    this.size = size
  }

  override fun withStyle(style: MonieButtonStyle) {
    this.style = style
  }

  override fun withShape(shape: MonieButtonShape) {
    this.shape = shape
  }

  override fun withTitle(text: String) {
    items.removeIf { it is Title }
    val index = if (items.any { it is StartIcon }) {
      1
    } else {
      0
    }
    items.add(index, Title(text = text))
  }

  override fun build(): MonieButtonConfig {
    return MonieButtonConfig(
      items = items,
      size = size ?: LARGE,
      shape = shape ?: MonieButtonShape.LARGE,
      style = style ?: ACCENT
    )
  }
}