package mon.ie.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import mon.ie.android.mediator.MediatorManager
import mon.ie.theme.MonieTheme

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonieTheme(isSystemDark = false) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    graph = navController.createAppNavGraph()
                )
            }
        }
    }


    override fun onDestroy() {
        if (isFinishing) {
            MediatorManager.clearMediators()
        }
        super.onDestroy()
    }
}