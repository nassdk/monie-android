package mon.ie.uikit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import mon.ie.theme.MonieTheme
import mon.ie.uikit.helpers.AlertDialogBundle

@Composable
fun MonieAlert(
  bundle: AlertDialogBundle,
  onDismissRequested: () -> Unit
) {

  Dialog(
    onDismissRequest = onDismissRequested,
    content = {

      Surface(
        modifier = Modifier.blur(radius = 6.dp),
        shape = MonieTheme.shapes.mediumShape,
        contentColor = MonieTheme.colors.background.primary,
        content = {
          Column(
            content = {
              Text(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(
                    top = MonieTheme.dimens.dp16,
                    start = MonieTheme.dimens.dp24,
                    end = MonieTheme.dimens.dp24
                  ),
                text = bundle.title.value,
                style = MonieTheme.typography.h16Medium,
                color = bundle.title.color ?: MonieTheme.colors.text.primary,
                textAlign = TextAlign.Center
              )

              Text(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = MonieTheme.dimens.dp4),
                text = bundle.title.value,
                style = MonieTheme.typography.b12Regular,
                color = bundle.title.color ?: MonieTheme.colors.text.secondary,
                textAlign = TextAlign.Center
              )

              if (bundle.confirmButton == null && bundle.cancelButton == null) {
                return@Column
              }

              Divider(
                color = MonieTheme.colors.background.border,
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = MonieTheme.dimens.dp16),
              )

              if (bundle.confirmButton != null) {
                Button(
                  onClick = { /*TODO*/ },
                  modifier = Modifier
                    .height(height = 42.dp)
                    .fillMaxWidth(),
                  elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
                  colors = ButtonDefaults.buttonColors(
                    backgroundColor = MonieTheme.colors.background.primary
                  ),
                  content = {
                    Text(
                      modifier = Modifier.padding(
                        horizontal = MonieTheme.dimens.dp24
                      ),
                      color = bundle.confirmButton.title.color
                        ?: MonieTheme.colors.background.primary,
                      style = MonieTheme.typography.b14Medium,
                      text = bundle.confirmButton.title.value,
                      textAlign = TextAlign.Center,
                    )
                  }
                )
              }

              if (bundle.cancelButton != null) {

                Divider(
                  color = MonieTheme.colors.background.border,
                  modifier = Modifier.fillMaxWidth()
                )

                Button(
                  onClick = { /*TODO*/ },
                  modifier = Modifier
                    .height(height = 42.dp)
                    .fillMaxWidth(),
                  elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
                  colors = ButtonDefaults.buttonColors(
                    backgroundColor = MonieTheme.colors.background.primary
                  ),
                  content = {
                    Text(
                      style = MonieTheme.typography.b14Medium,
                      modifier = Modifier.padding(
                        horizontal = MonieTheme.dimens.dp24
                      ),
                      color = bundle.cancelButton.title.color
                        ?: MonieTheme.colors.text.primary,
                      text = bundle.cancelButton.title.value,
                      textAlign = TextAlign.Center,
                    )
                  }
                )
              }
            }
          )
        }
      )
    }
  )
}