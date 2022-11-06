package mon.ie.uikit.helpers.button

import androidx.annotation.DrawableRes

sealed class MonieButtonItem {
  class StartIcon(@DrawableRes val icon: Int) : MonieButtonItem()
  class EndIcon(@DrawableRes val icon: Int) : MonieButtonItem()
  class Title(val text: String) : MonieButtonItem()
}

interface MonieButtonBuilder {
  fun withSize(size: MonieButtonSize)
  fun withStyle(style: MonieButtonStyle)
  fun withShape(shape: MonieButtonShape)
  fun withStartIcon(@DrawableRes iconRes: Int)
  fun withEndIcon(@DrawableRes iconRes: Int)
  fun withTitle(text: String)
  fun build(): MonieButtonConfig
}