package mon.ie.uikit.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mon.ie.theme.MonieDimens
import mon.ie.uikit.components.buttons.MonieButton
import mon.ie.uikit.helpers.ActionSheetBundle
import mon.ie.uikit.helpers.button.MonieButtonShape
import mon.ie.uikit.helpers.button.MonieButtonStyle
import mon.ie.uikit.helpers.nodes.ButtonNode

@Suppress("MagicNumber")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ActionSheet(bundle: ActionSheetBundle) {

    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(0.dp),
        sheetElevation = 0.dp,
        sheetState = bundle.state,
        modifier = Modifier.fillMaxSize(),
        sheetContentColor = Color.Transparent,
        sheetBackgroundColor = Color.Transparent,
        sheetContent = {
            bundle.content.forEachIndexed { index, button ->

                ContextualButton(
                    onClick = {
                        scope.launch { bundle.state.hide() }
                    },
                    firstItem = index == 0,
                    lastItem = index == bundle.content.lastIndex,
                    button = button
                )

                if (index != bundle.content.lastIndex) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = MonieDimens.dp16)
                            .fillMaxWidth(),
                        color = Color(0x00EBEDEE)
                    )
                }
            }

            MonieButton(
                onClick = bundle.onCancel,
                style = MonieButtonStyle.NONE,
                shape = MonieButtonShape.LARGE,
                modifier = Modifier
                    .padding(all = MonieDimens.dp16)
                    .fillMaxWidth(),
                builder = {
                    withTitle(text = "Cancel")
                }
            )
        },
        content = {},
    )

    BackHandler {
        scope.launch {
            bundle.onCancel.invoke()
            scope.launch {
                bundle.state.hide()
            }
        }
    }
}

@Composable
private fun ContextualButton(
    onClick: () -> Unit,
    firstItem: Boolean,
    lastItem: Boolean,
    button: ButtonNode
) {

    MonieButton(
        onClick = {
            button.onClick.invoke()
            onClick.invoke()
        },
        style = MonieButtonStyle.NONE,
        shape = getShapeForButton(isLast = lastItem, isFirst = firstItem),
        modifier = Modifier
            .padding(horizontal = MonieDimens.dp16)
            .fillMaxWidth(),
        withClickAnimation = false,
        builder = {
            withTitle(text = button.title)
        }
    )
}

@Composable
private fun getShapeForButton(isLast: Boolean, isFirst: Boolean): MonieButtonShape {
    return when {
        isLast -> MonieButtonShape.BOTTOMED
        isFirst -> MonieButtonShape.TOPPED
        else -> MonieButtonShape.NONE
    }
}

