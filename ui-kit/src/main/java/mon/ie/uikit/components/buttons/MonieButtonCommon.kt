package mon.ie.uikit.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mon.ie.uikit.helpers.animatedOnClick
import mon.ie.uikit.helpers.button.MonieButtonColors
import mon.ie.uikit.helpers.button.MonieButtonShape
import mon.ie.uikit.helpers.button.MonieButtonShape.LARGE

private const val BUTTON_CLICK_SCALE_FACTORY = .95f

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MonieButtonCommon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: MonieButtonShape = LARGE,
    enabled: Boolean = true,
    colors: MonieButtonColors,
    content: @Composable RowScope.() -> Unit
) {

    val backgroundColor by colors.backgroundColor(isEnabled = enabled)
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        onClick = onClick,
        modifier = modifier.animatedOnClick(
            interactionSource = interactionSource,
            scaleDownFactor = BUTTON_CLICK_SCALE_FACTORY
        ),
        enabled = enabled,
        shape = shape.value.invoke(),
        color = backgroundColor,
        contentColor = backgroundColor,
        elevation = 0.dp,
        interactionSource = interactionSource,
        content = {
            CompositionLocalProvider(LocalContentAlpha provides backgroundColor.alpha) {
                ProvideTextStyle(
                    value = MaterialTheme.typography.button,
                    content = {
                        Row(
                            modifier = Modifier.padding(ButtonDefaults.ContentPadding),
                            verticalAlignment = Alignment.CenterVertically,
                            content = content
                        )
                    }
                )
            }
        }
    )
}