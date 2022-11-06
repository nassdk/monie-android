package mon.ie.uikit.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mon.ie.theme.MonieTheme
import mon.ie.uikit.helpers.button.MonieButtonBuilder
import mon.ie.uikit.helpers.button.MonieButtonBuilderImpl
import mon.ie.uikit.helpers.button.MonieButtonColors
import mon.ie.uikit.helpers.button.MonieButtonConfig
import mon.ie.uikit.helpers.button.MonieButtonItem.EndIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.StartIcon
import mon.ie.uikit.helpers.button.MonieButtonItem.Title

@Composable
fun MonieButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  isEnabled: Boolean = true,
  isLoading: Boolean = false,
  builder: MonieButtonBuilder.() -> Unit
) {
  val config = MonieButtonBuilderImpl().apply(builder).build()
  val width = remember { mutableStateOf(0) }

  MonieButtonCommon(
    modifier = modifier
      .height(height = config.size.buttonHeight.invoke()),
    onClick = onClick,
    enabled = isEnabled && !isLoading,
    shape = config.shape,
    colors = MonieButtonColors(
      backgroundColor = config.style.backgroundColor.invoke()
    ),
    content = {
      if (isLoading) {
        LoadingProgress(config = config, width = width.value)
      } else {
        config.items.forEach { item ->
          when (item) {
            is StartIcon -> item.MakeIcon()
            is EndIcon -> item.MakeIcon()
            is Title -> MakeTitle(
              text = item.text,
              config = config
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
  text: String,
  config: MonieButtonConfig
) {
  val hasStartIcon = config.hasStartIcon
  val hasEndIcon = config.hasEndIcon
  Text(
    text = text,
    textAlign = TextAlign.Center,
    color = config.style.textColor.invoke(),
    fontSize = config.size.textSize.invoke(),
    maxLines = 1,
    modifier = Modifier
      .padding(
        start = if (hasStartIcon) MonieTheme.dimens.dp12 else 0.dp,
        end = if (hasEndIcon) MonieTheme.dimens.dp12 else 0.dp,
      )
      .then(calculateModifier(config = config))
  )
}

@Composable
internal fun LoadingProgress(config: MonieButtonConfig, width: Int) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxHeight()
      .width(width = Dp(width.toFloat())),
    content = {
      CircularProgressIndicator(
        strokeWidth = 2.dp,
        modifier = Modifier
          .size(size = config.size.progressIndicatorSize.invoke())
      )
    }
  )
}

private fun RowScope.calculateModifier(config: MonieButtonConfig): Modifier {
  val hasStartIcon = config.hasStartIcon
  val hasEndIcon = config.hasEndIcon

  return when {

    // Don't support icons for small button
    (hasStartIcon || hasEndIcon) && config.isSmall -> {
      throw IllegalArgumentException(
        "Small buttons icons is not supported yet"
      )
    }

    !hasStartIcon && !hasEndIcon && config.isSmall -> Modifier

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