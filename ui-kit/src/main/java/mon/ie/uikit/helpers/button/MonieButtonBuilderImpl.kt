package mon.ie.uikit.helpers.button

import mon.ie.uikit.helpers.button.MonieButtonItem.EndIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.StartIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.Title
import mon.ie.uikit.helpers.nodes.TextNode
import mon.ie.uikit.helpers.nodes.toNode
import kotlin.LazyThreadSafetyMode.NONE

class MonieButtonBuilderImpl : MonieButtonBuilder {

    private val items by lazy(NONE) {
        ArrayList<MonieButtonItem>(3)
    }

    override fun withStartIcon(iconRes: Int) {
        items.removeIf { it is StartIcon }
        items.add(0, StartIcon(icon = iconRes))
    }

    override fun withEndIcon(iconRes: Int) {
        items.removeIf { it is EndIcon }
        items.add(EndIcon(icon = iconRes))
    }

    override fun withTitle(text: String) {
        items.removeIf { it is Title }
        val index = if (items.any { it is StartIcon }) {
            1
        } else {
            0
        }
        items.add(index, Title(node = text.toNode()))
    }

    override fun withTitle(node: TextNode) {
        items.removeIf { it is Title }
        val index = if (items.any { it is StartIcon }) {
            1
        } else {
            0
        }
        items.add(index, Title(node = node))
    }

    override fun build(): MonieButtonConfig {
        return MonieButtonConfig(items = items)
    }
}