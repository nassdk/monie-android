package mon.ie.uikit.helpers

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import mon.ie.uikit.helpers.nodes.ButtonNode

class ActionSheetBundle @OptIn(ExperimentalMaterialApi::class) constructor(
    val state: ModalBottomSheetState,
    val onCancel: () -> Unit,
    val content: List<ButtonNode>
)