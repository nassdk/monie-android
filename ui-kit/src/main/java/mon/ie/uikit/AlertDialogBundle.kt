package mon.ie.uikit

import androidx.compose.ui.window.DialogProperties

class AlertDialogBundle(
  val title: TextPoint,
  val subtitle: TextPoint? = null,
  val confirmButton: ButtonPoint? = null,
  val cancelButton: ButtonPoint? = null,
  val properties: DialogProperties = DialogProperties()
)