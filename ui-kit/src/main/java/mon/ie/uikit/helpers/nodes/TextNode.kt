package mon.ie.uikit.helpers.nodes

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import mon.ie.theme.MonieColors
import mon.ie.theme.MonieTypograhy

/**
 * Node component for ui-components
 */

data class TextNode internal constructor(
    val value: String,
    val color: @Composable () -> Color,
    val style: @Composable () -> TextStyle
) {

    constructor(value: String, color: Color, style: TextStyle) : this(
        value = value,
        color = { color },
        style = { style }
    )

    constructor(value: String, color: Color, style: @Composable () -> TextStyle) : this(
        value = value,
        color = { color },
        style = style
    )

    constructor(value: String) : this(
        value = value,
        color = { MonieColors.text.primary },
        style = { MonieTypograhy.b14Regular }
    )

    constructor(value: String, color: Color) : this(
        value = value,
        color = { color },
        style = { MonieTypograhy.b14Regular }
    )

    constructor(value: String, style: TextStyle) : this(
        value = value,
        color = { MonieColors.text.primary },
        style = { style }
    )

    constructor(value: String, style: @Composable () -> TextStyle) : this(
        value = value,
        color = { MonieColors.text.primary },
        style = style
    )
}

fun String.toNode(): TextNode {
    return TextNode(value = this)
}