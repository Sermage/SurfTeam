package com.sermage.surfteam.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class DrawableResources(
    @DrawableRes val surfLogo: Int,
    @DrawableRes val androidLogo: Int,
    @DrawableRes val androidLogoGrey: Int,
    @DrawableRes val splashImage: Int
)

val LocalDrawableResources = staticCompositionLocalOf<DrawableResources> {
    error("CompositionLocal DrawableResources is not presented")
}

