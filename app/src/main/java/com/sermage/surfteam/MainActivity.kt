package com.sermage.surfteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.sermage.surfteam.navigation.NavigationHost
import com.sermage.surfteam.settings.isDarkTheme
import com.sermage.surfteam.ui.screens.main.SettingsViewModel
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = hiltViewModel<SettingsViewModel>()
            val currentTheme = vm.themeState.collectAsState()
            SurfTeamTheme(darkTheme = currentTheme.value.isDarkTheme()) {
                NavigationHost()
            }
        }
    }
}
