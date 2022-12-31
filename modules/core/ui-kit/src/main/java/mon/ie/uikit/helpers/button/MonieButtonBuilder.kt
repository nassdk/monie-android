package mon.ie.uikit.helpers.button

import androidx.annotation.DrawableRes
import mon.ie.uikit.helpers.nodes.TextNode

sealed class MonieButtonItem {
    class StartIcon(@DrawableRes val icon: Int) : MonieButtonItem()
    class EndIcon(@DrawableRes val icon: Int) : MonieButtonItem()
    class Title(val node: TextNode) : MonieButtonItem()
}

interface MonieButtonBuilder {
    fun withStartIcon(@DrawableRes iconRes: Int)
    fun withEndIcon(@DrawableRes iconRes: Int)
    fun withTitle(text: String)
    fun withTitle(text: TextNode)
    fun build(): MonieButtonConfig
}