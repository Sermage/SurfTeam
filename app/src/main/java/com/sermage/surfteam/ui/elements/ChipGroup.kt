package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.data.Skill
import com.sermage.surfteam.data.Skills.items
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ChipGroup(
    modifier: Modifier = Modifier,
    skills: List<Skill>
) {
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = 4.dp,
        crossAxisSpacing = 6.dp

    ) {
        skills.forEach { skill ->
            Chip(
                name = skill.name,
                color = skill.color
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ChipGroupPreview() {
    SurfTeamTheme {
        ChipGroup(
            skills = items,
            modifier = Modifier.widthIn(max = 200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroupDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.surface) {
            ChipGroup(
                skills = items,
                modifier = Modifier.widthIn(max = 200.dp)
            )
        }

    }
}