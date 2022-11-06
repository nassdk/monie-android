package mon.ie.uikit.helpers

import androidx.compose.ui.window.DialogProperties
import mon.ie.uikit.helpers.nodes.ButtonNode
import mon.ie.uikit.helpers.nodes.TextNode

class AlertDialogBundle(
    val title: TextNode,
    val subtitle: TextNode? = null,
    val confirmButton: ButtonNode? = null,
    val cancelButton: ButtonNode? = null,
    val properties: DialogProperties = DialogProperties()
)