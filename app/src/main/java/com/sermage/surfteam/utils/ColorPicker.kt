package com.sermage.surfteam.utils

import androidx.compose.ui.graphics.Color
import com.sermage.surfteam.ui.theme.*
import kotlin.math.absoluteValue

object ColorPicker {
    fun pickColor(projectName: String): Color {
        val palette = listOf(Orange, Green, Blue, Red, Purple500, Teal200)
        return palette[projectName.hashCode().absoluteValue % palette.size]
    }
}