package mon.ie.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import mon.ie.ui.theme.MonieTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonieTheme(isSystemDark = false) {
                Column(modifier = Modifier.background(color = MonieTheme.colors.background.primary)) {

                }
            }
        }
    }
}