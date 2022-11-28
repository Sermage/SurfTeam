package com.sermage.surfteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sermage.surfteam.navigation.NavigationHost
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfTeamTheme {
                NavigationHost()
            }
        }
    }
}
