package mon.ie.uikit.helpers.alert

import androidx.compose.ui.graphics.Color
import mon.ie.uikit.helpers.nodes.ButtonNode
import mon.ie.uikit.helpers.nodes.TextNode

sealed class AlertDialogItem {
    class Title(val node: TextNode) : AlertDialogItem()
    class Subtitle(val node: TextNode) : AlertDialogItem()
    class Button(val node: ButtonNode) : AlertDialogItem()
}

interface AlertDialogBuilder {
    fun withTitle(value: String)
    fun withSubtitle(value: String)
    fun withButton(value: String, onClick: () -> Unit)
    fun withButton(value: String, color: Color, onClick: () -> Unit)
    fun build(): AlertDialogConfig
}