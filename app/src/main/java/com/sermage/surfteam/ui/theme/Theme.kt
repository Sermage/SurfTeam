package com.sermage.surfteam.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = DodgerBlue,
    background = BlackPearl,
    onBackground = White,
    surface = Cinder,
    onSurface = White
)

private val LightColorPalette = lightColors(
    primary = Blue,
    background = Milk,
    onBackground = Grey,
    surface = White,
    onSurface = LuckyPoint
)

@Composable
fun SurfTeamTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colors.background, darkIcons = !darkTheme)
}