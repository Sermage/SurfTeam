package com.sermage.surfteam.ui.screens.project_details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Project
import com.sermage.surfteam.data.projects
import com.sermage.surfteam.settings.isDarkTheme
import com.sermage.surfteam.ui.elements.common.ActionButton
import com.sermage.surfteam.ui.elements.project.ProjectLabel
import com.sermage.surfteam.ui.screens.main.SettingsViewModel
import com.sermage.surfteam.ui.theme.LuckyPoint
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.sermage.surfteam.ui.theme.White
import com.sermage.surfteam.utils.ColorPicker

@Composable
fun ProjectDetailsScreen(
    modifier: Modifier = Modifier,
    projectName: String,
    settingsViewModel: SettingsViewModel = hiltViewModel(),
    backClick: () -> Unit
) {
    BackHandler {
        backClick()
    }
    val currentTheme = settingsViewModel.themeState.collectAsState()

    val project = projects.find { it.name == projectName } ?: return

    SurfTeamTheme(darkTheme = currentTheme.value.isDarkTheme()) {
        ConstraintLayout(
            modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState())
        ) {

            val (topSection, infoBox) = createRefs()

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .constrainAs(topSection) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            ) {
                ActionButton(
                    iconRes = R.drawable.ic_arrow_left, iconContentDescription = "back icon",
                    modifier = Modifier.padding(top = 8.dp, start = 20.dp)
                ) {
                    backClick()
                }

                Card(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 20.dp)
                        .shadow(ambientColor = LuckyPoint.copy(alpha = 0.1f), elevation = 10.dp),
                    backgroundColor = White,
                    shape = MaterialTheme.shapes.medium
                ) {
                    ProjectLabel(
                        projectName = project.name,
                        color = ColorPicker.pickColor(project.name),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 34.dp, vertical = 16.dp)
                    )
                }

                Text(
                    text = project.name,
                    style = MaterialTheme.typography.body1.copy(fontSize = 24.sp),
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 20.dp)

                )
            }

            ProjectInfoBox(project = project,
                modifier = Modifier.constrainAs(infoBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topSection.bottom)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}

@Composable
fun ProjectInfoBox(
    modifier: Modifier = Modifier,
    project: Project
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 40.dp)
            .shadow(elevation = 10.dp, ambientColor = LuckyPoint.copy(alpha = 0.1f)),
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    ) {

        Column {
            Text(
                text = stringResource(id = R.string.project_details_about_project_title),
                style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                modifier = Modifier.padding(top = 32.dp, start = 20.dp)
            )

            Text(
                text = project.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(top = 16.dp, start = 20.dp)
            )
            Divider(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 32.dp),
                color = MaterialTheme.colors.background
            )

            Text(
                text = stringResource(id = R.string.project_details_team_title),
                style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                modifier = Modifier.padding(start = 20.dp)
            )

            TeamCard(team = project.participants, modifier = Modifier.padding(top = 16.dp))
            Divider(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 32.dp),
                color = MaterialTheme.colors.background
            )

            ProjectDurationCard(
                modifier = Modifier
                    .padding(bottom = 48.dp, start = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectDetailsPreview() {
    SurfTeamTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            ProjectDetailsScreen(projectName = projects.first().name) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectDetailsDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            ProjectDetailsScreen(projectName = projects.first().name) {
            }
        }
    }
}