package com.sermage.surfteam.data

import androidx.compose.ui.graphics.Color
import com.sermage.surfteam.ui.theme.*

data class Skill(
    val name: String,
    val color: Color? = null
)

object Skills {
    val android = listOf(
        Skill(name = "Android", color = Green),
        Skill(name = "Compose"),
        Skill(name = "RxJava"),
        Skill(name = "Dagger"),
        Skill(name = "Coroutines")
    )
    val ios = listOf(
        Skill(name = "IOS", color = Red),
        Skill(name = "SwiftUi"),
        Skill(name = "XCode"),
        Skill(name = "MVVM")
    )
    val project = listOf(
        Skill(name = "Project management", color = Orange),
        Skill(name = "Productive"),
        Skill(name = "Jira"),
        Skill(name = "Team building"),
        Skill(name = "Scrum")
    )
    val design = listOf(
        Skill("Design", color = Blue),
        Skill(name = "Figma"),
        Skill("Adobe Photoshop"),
        Skill(name = "Adobe Illustrator")
    )
    val analytic = listOf(
        Skill(name = "Analytic", color = Teal200),
        Skill(name = "Confluence"),
        Skill(name = "Mobile features")
    )
}
