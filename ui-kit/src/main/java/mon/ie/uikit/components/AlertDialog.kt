package mon.ie.uikit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import mon.ie.theme.MonieTheme
import mon.ie.uikit.components.buttons.MonieButton
import mon.ie.uikit.helpers.alert.AlertDialogBuilder
import mon.ie.uikit.helpers.alert.AlertDialogBuilderImpl
import mon.ie.uikit.helpers.alert.AlertDialogItem
import mon.ie.uikit.helpers.button.MonieButtonShape.BOTTOMED
import mon.ie.uikit.helpers.button.MonieButtonShape.NONE
import mon.ie.uikit.helpers.button.MonieButtonStyle

@Composable
fun MonieAlert(
    onDismissRequested: () -> Unit,
    builder: AlertDialogBuilder.() -> Unit,
    properties: DialogProperties = DialogProperties(),
) {

    val config = AlertDialogBuilderImpl().apply(builder).build()

    Dialog(
        onDismissRequest = onDismissRequested,
        properties = properties,
        content = {
            Surface(
                modifier = Modifier.blur(radius = 6.dp),
                shape = MonieTheme.shapes.mediumShape,
                content = {

                    Column(
                        content = {
                            val firstButtonIndex = config.items.indexOfFirst {
                                it is AlertDialogItem.Button
                            }

                            config.items.forEachIndexed { index, item ->
                                when (item) {
                                    is AlertDialogItem.Title -> AlertTitle(model = item)
                                    is AlertDialogItem.Subtitle -> AlertSubtitle(model = item)
                                    is AlertDialogItem.Button -> AlertButton(
                                        model = item,
                                        firstItem = index == firstButtonIndex,
                                        lastItem = index == config.items.lastIndex
                                    )
                                }
                            }
                        }
                    )
                }
            )
        }
    )
}

@Composable
private fun AlertTitle(model: AlertDialogItem.Title) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MonieTheme.dimens.dp16,
                start = MonieTheme.dimens.dp24,
                end = MonieTheme.dimens.dp24
            ),
        text = model.node.value,
        style = model.node.style.invoke(),
        color = model.node.color.invoke(),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun AlertSubtitle(model: AlertDialogItem.Subtitle) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MonieTheme.dimens.dp4),
        text = model.node.value,
        style = model.node.style.invoke(),
        color = model.node.color.invoke(),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun AlertButton(
    model: AlertDialogItem.Button,
    firstItem: Boolean,
    lastItem: Boolean
) {

    Divider(
        color = MonieTheme.colors.background.border,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = if (firstItem) MonieTheme.dimens.dp16 else 0.dp),
    )

    MonieButton(
        onClick = model.node.onClick,
        shape = if (lastItem) BOTTOMED else NONE,
        style = MonieButtonStyle.NONE,
        modifier = Modifier
            .height(height = 42.dp)
            .fillMaxWidth(),
        builder = {
            withTitle(text = model.node.title)
        }
    )
}