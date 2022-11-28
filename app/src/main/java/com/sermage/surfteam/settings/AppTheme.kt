package com.sermage.surfteam.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

enum class AppTheme {
    MODE_DAY,
    MODE_NIGHT,
    MODE_AUTO;

    companion object {
        fun fromOrdinal(value: Int) = values()[value]
    }
}

@Composable
fun AppTheme.isDarkTheme() = when (this) {
    AppTheme.MODE_AUTO -> isSystemInDarkTheme()
    AppTheme.MODE_DAY -> false
    AppTheme.MODE_NIGHT -> true
}