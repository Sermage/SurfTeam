package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Project
import com.sermage.surfteam.data.projects
import com.sermage.surfteam.ui.elements.project.AvatarRow
import com.sermage.surfteam.ui.elements.project.ProjectLabel
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.sermage.surfteam.utils.ColorPicker

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onProjectClick: (Project) -> Unit = {},
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp),
        elevation = 10.dp,
        onClick = { onProjectClick(project) }
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (label, participantsNumber, name) = createRefs()
            val avatars = createRef()

            ProjectLabel(projectName = project.name,
                color = ColorPicker.pickColor(project.name),
                modifier = Modifier
                    .constrainAs(label) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    })

            Text(
                text = pluralStringResource(
                    id = R.plurals.participants,
                    count = project.participants.size,
                    project.participants.size
                ),
                style = MaterialTheme.typography.body1.copy(fontSize = 13.sp),
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.constrainAs(participantsNumber) {
                    top.linkTo(label.bottom, margin = 18.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
            )

            Text(
                text = project.name,
                style = MaterialTheme.typography.h1.copy(fontSize = 15.sp),
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(participantsNumber.bottom, margin = 6.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
            )

            AvatarRow(photos = project.participants.map { it.photoUrl },
                modifier = Modifier
                    .constrainAs(avatars) {
                        top.linkTo(parent.top, margin = 23.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                    })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectCardPreview() {
    SurfTeamTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            ProjectCard(project = projects[0])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectCardPreviewDark() {
    SurfTeamTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            ProjectCard(project = projects[0])
        }
    }
}