package com.sermage.surfteam.ui.screens.main

import androidx.lifecycle.ViewModel
import com.sermage.surfteam.settings.AppTheme
import com.sermage.surfteam.settings.SettingsStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsStorage: SettingsStorage
) : ViewModel() {

    val themeState = MutableStateFlow(settingsStorage.theme)

    fun changeTheme(theme: AppTheme) {
        settingsStorage.theme = theme
        themeState.value = theme
    }
}