package mon.ie.uikit.helpers

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState

class ContextualPickerBundle @OptIn(ExperimentalMaterialApi::class) constructor(
  val state: ModalBottomSheetState,
  val onCancel: () -> Unit,
  val content: List<ButtonPoint>
)