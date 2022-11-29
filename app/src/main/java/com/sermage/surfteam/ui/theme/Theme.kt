package com.sermage.surfteam.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sermage.surfteam.R

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

val LightDrawableResources = DrawableResources(
    surfLogo = R.drawable.surf_logo,
    androidLogo = R.drawable.android_logo,
    androidLogoGrey = R.drawable.android_logo_grey,
    splashImage = R.drawable.splash_image
)

val DarkDrawableResources = DrawableResources(
    surfLogo = R.drawable.surf_logo_night,
    androidLogo = R.drawable.android_logo_night,
    androidLogoGrey = R.drawable.android_logo_grey_night,
    splashImage = R.drawable.splash_image_night
)

@Composable
fun SurfTeamTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val resources = if (darkTheme) {
        DarkDrawableResources
    } else {
        LightDrawableResources
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes
    ) {
        CompositionLocalProvider(
            values = arrayOf(LocalDrawableResources provides resources),
            content
        )
    }


    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colors.background, darkIcons = !darkTheme)
}