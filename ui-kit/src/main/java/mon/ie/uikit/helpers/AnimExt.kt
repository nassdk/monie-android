package mon.ie.uikit.helpers

import android.os.SystemClock
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val PRESS_ANIMATION_MIN_TIME = 150

@Suppress("MagicNumber")
fun Modifier.animatedOnClick(
    interactionSource: InteractionSource,
    scaleDownFactor: Float
): Modifier = composed {
    val animatable = remember { Animatable(1F) }

    LaunchedEffect(animatable, interactionSource) {
        var lastPressTime = 0L
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    lastPressTime = SystemClock.uptimeMillis()
                    launch { animatable.animateTo(scaleDownFactor) }
                }
                is PressInteraction.Release, is PressInteraction.Cancel -> launch {
                    delay(PRESS_ANIMATION_MIN_TIME - (SystemClock.uptimeMillis() - lastPressTime))
                    animatable.animateTo(1F, spring(0.4F, Spring.StiffnessLow))
                }
            }
        }
    }

    scale(animatable.value)
}

private val animatedBackgroundColorOnClickAnimationSpec = spring<Color>(
    dampingRatio = Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessMedium
)

/**
 * Default background color animation for clickable elements
 * @param interactionSource Interaction source used for clickable element
 */
fun Modifier.animatedBackgroundColorOnClick(
    interactionSource: InteractionSource,
    pressedColor: Color,
    backgroundColor: Color
) = composed(
    inspectorInfo = {
        debugInspectorInfo {
            name = "animatedBackgroundColorOnClick"
            properties["interactionSource"] = interactionSource
        }
    }
) {
    val animatable = remember { Animatable(backgroundColor) }

    LaunchedEffect(animatable, interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    animatable.animateTo(
                        pressedColor,
                        animatedBackgroundColorOnClickAnimationSpec
                    )
                }
                is PressInteraction.Release, is PressInteraction.Cancel -> launch {
                    animatable.animateTo(
                        backgroundColor,
                        animatedBackgroundColorOnClickAnimationSpec
                    )
                }
            }
        }
    }

    background(animatable.value)
}