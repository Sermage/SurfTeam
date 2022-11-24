package com.sermage.surfteam.data

import androidx.compose.ui.graphics.Color
import com.sermage.surfteam.ui.theme.Green

data class Skill(
    val name: String,
    val color: Color? = null
)

object Skills{
    val items = listOf(
        Skill(name = "Android", color = Green),
        Skill(name = "Compose"),
        Skill(name = "RxJava"),
        Skill(name = "Dagger"),
        Skill(name = "Coroutines")
    )
}
