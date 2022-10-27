package mon.ie.uikit

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mon.ie.theme.MonieTheme
import mon.ie.uikit.helpers.ActionSheetBundle

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
                Button(
                    onClick = {
                        scope.launch {
                            bundle.state.hide()
                        }
                        button.onClick.invoke()
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MonieTheme.colors.background.primary),
                    shape = calculateContextualShape(
                        index = index,
                        lastIndex = bundle.content.lastIndex
                    ),
                    modifier = Modifier
                        .padding(horizontal = MonieTheme.dimens.dp16)
                        .fillMaxWidth()
                        .height(48.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .background(color = MonieTheme.colors.background.secondary) //TODO Make it image
                                .padding(start = MonieTheme.dimens.dp12),
                        )
                        Text(
                            text = button.title.value,
                            color = button.title.color ?: MonieTheme.colors.text.primary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = MonieTheme.dimens.dp12),
                            style = MonieTheme.typography.b14Regular,
                        )
                    }
                )

                if (index != bundle.content.lastIndex) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = MonieTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = Color(0xFFEBEDEE)
                    )
                }
            }

            Button(
                onClick = bundle.onCancel,
                colors = ButtonDefaults.buttonColors(backgroundColor = MonieTheme.colors.background.primary),
                shape = MonieTheme.shapes.mediumShape,
                modifier = Modifier
                    .padding(all = MonieTheme.dimens.dp16)
                    .fillMaxWidth()
                    .height(44.dp),
                content = {
                    Text(
                        text = "Cancel",
                        color = MonieTheme.colors.text.primary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MonieTheme.typography.b14Medium
                    )
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

private fun calculateContextualShape(index: Int, lastIndex: Int): Shape {
    return when (index) {
        lastIndex -> {
            RoundedCornerShape(
                topEnd = 0.dp,
                topStart = 0.dp,
                bottomEnd = 12.dp,
                bottomStart = 12.dp
            )
        }

        0 -> {
            RoundedCornerShape(
                topEnd = 12.dp,
                topStart = 12.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        }

        else -> {
            RoundedCornerShape(size = 0.dp)
        }
    }
}

