package mon.ie.uikit.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mon.ie.theme.MonieTheme
import mon.ie.uikit.helpers.button.*
import mon.ie.uikit.helpers.button.MonieButtonItem.*
import mon.ie.uikit.helpers.button.MonieButtonSize.LARGE
import mon.ie.uikit.helpers.button.MonieButtonSize.SMALL
import mon.ie.uikit.helpers.button.MonieButtonStyle.ACCENT
import mon.ie.uikit.helpers.nodes.TextNode

@Composable
fun MonieButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    size: MonieButtonSize = LARGE,
    shape: MonieButtonShape = MonieButtonShape.LARGE,
    style: MonieButtonStyle = ACCENT,
    builder: MonieButtonBuilder.() -> Unit
) {
    val config = MonieButtonBuilderImpl().apply(builder).build()

    MonieButtonCommon(
        modifier = modifier.height(height = size.buttonHeight.invoke()),
        onClick = onClick,
        enabled = isEnabled && !isLoading,
        shape = shape,
        colors = MonieButtonColors(backgroundColor = style.backgroundColor.invoke()),
        content = {
            if (isLoading) {
                LoadingProgress(size = size.progressIndicatorSize.invoke())
            } else {
                config.items.forEach { item ->
                    when (item) {
                        is StartIcon -> item.MakeIcon()
                        is EndIcon -> item.MakeIcon()
                        is Title -> MakeTitle(
                            text = item.node,
                            config = config,
                            isSmall = size == SMALL
                        )
                    }
                }
            }
        }
    )
}

@Composable
internal fun StartIcon.MakeIcon() {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null
    )
}

@Composable
internal fun EndIcon.MakeIcon() {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null
    )
}

@Composable
internal fun RowScope.MakeTitle(
    text: TextNode,
    config: MonieButtonConfig,
    isSmall: Boolean
) {
    val hasStartIcon = config.hasStartIcon
    val hasEndIcon = config.hasEndIcon
    Text(
        text = text.value,
        style = text.style.invoke(),
        textAlign = TextAlign.Center,
        color = text.color.invoke(),
        maxLines = 1,
        modifier = Modifier
            .padding(
                start = if (hasStartIcon) MonieTheme.dimens.dp12 else 0.dp,
                end = if (hasEndIcon) MonieTheme.dimens.dp12 else 0.dp,
            )
            .then(calculateModifier(config = config, isSmall = isSmall))
    )
}

@Composable
internal fun LoadingProgress(size: Dp) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight(),
        content = {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                modifier = Modifier.size(size = size)
            )
        }
    )
}

private fun RowScope.calculateModifier(
    isSmall: Boolean,
    config: MonieButtonConfig
): Modifier {
    val hasStartIcon = config.hasStartIcon
    val hasEndIcon = config.hasEndIcon

    return when {

        // Don't support icons for small button
        (hasStartIcon || hasEndIcon) && isSmall -> {
            throw IllegalArgumentException(
                "Small buttons icons is not supported yet"
            )
        }

        !hasStartIcon && !hasEndIcon && isSmall -> Modifier

        // Text should be centered if there are not icons in btn
        !hasStartIcon && !hasEndIcon -> Modifier
            .fillMaxWidth()
            .weight(weight = 1f, fill = true)

        // Text should be centered if there are icons on botn sides
        hasStartIcon && hasEndIcon -> Modifier.weight(
            weight = 1f,
            fill = true
        )

        // Text won't be centered if there is icon on one side
        else -> Modifier
    }
}