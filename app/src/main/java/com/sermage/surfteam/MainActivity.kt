package com.sermage.surfteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sermage.surfteam.ui.screens.SplashScreen
import com.sermage.surfteam.ui.theme.SurfTeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfTeamTheme {
               SplashScreen()
            }
        }
    }
}
