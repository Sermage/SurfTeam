package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.data.projects
import com.sermage.surfteam.ui.elements.ProjectCard

@Composable
fun ProjectsTabContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp, top = 12.dp)
    ) {
        items(projects) { project ->
            ProjectCard(project = project)
        }
    }
}

@Preview
@Composable
fun ProjectsTabContentPreview() {
    Surface {
        ProjectsTabContent()
    }
}