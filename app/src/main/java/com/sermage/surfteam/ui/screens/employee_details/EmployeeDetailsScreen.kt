package com.sermage.surfteam.ui.screens.employee_details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Employee
import com.sermage.surfteam.data.employees
import com.sermage.surfteam.settings.isDarkTheme
import com.sermage.surfteam.ui.elements.ChipGroup
import com.sermage.surfteam.ui.elements.common.ActionButton
import com.sermage.surfteam.ui.screens.main.SettingsViewModel
import com.sermage.surfteam.ui.theme.LuckyPoint
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun EmployeeDetailsScreen(
    modifier: Modifier = Modifier,
    employeeId: String,
    settingsViewModel: SettingsViewModel = hiltViewModel(),
    backClick: () -> Unit = {},
    onProjectCardClick: (String) -> Unit = {}
) {
    BackHandler {
        backClick()
    }
    val currentTheme = settingsViewModel.themeState.collectAsState()

    val employee = employees.find { it.id == employeeId } ?: return
    SurfTeamTheme(darkTheme = currentTheme.value.isDarkTheme()) {

        ConstraintLayout(
            modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState())
        ) {
            val (backButton, callButton, infoColumn) = createRefs()
            val infoBox = createRef()

            ActionButton(
                iconRes = R.drawable.ic_arrow_left,
                iconContentDescription = "Back button",
                modifier = Modifier
                    .padding(top = 8.dp, start = 20.dp)
                    .constrainAs(backButton) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            ) {
                backClick()
            }
            ActionButton(
                iconRes = R.drawable.ic_call,
                iconContentDescription = "Call icon",
                modifier = Modifier
                    .padding(top = 8.dp, end = 20.dp)
                    .constrainAs(callButton) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            ) {

            }

            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .constrainAs(infoColumn) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(backButton.bottom)
                    }
            ) {
                Image(
                    painter = rememberImagePainter(data = employee.photoUrl) {
                        placeholder(R.drawable.android_logo_night)
                        transformations(CircleCropTransformation())
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .size(112.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = employee.name,
                    style = MaterialTheme.typography.body1.copy(fontSize = 24.sp),
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = employee.phoneNumber,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = stringResource(
                        id = R.string.personal_info_text,
                        employee.age,
                        employee.residentialAddress
                    ),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

            }

            EmployeeInfoBox(employee = employee,
                modifier = Modifier.constrainAs(infoBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(infoColumn.bottom, margin = 40.dp)
                    bottom.linkTo(parent.bottom)
                },
                onProjectCardClick = { onProjectCardClick(it) })

        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun EmployeeInfoBox(
    modifier: Modifier = Modifier,
    employee: Employee,
    onProjectCardClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                color = MaterialTheme.colors.surface
            )
            .shadow(elevation = 10.dp, ambientColor = LuckyPoint.copy(alpha = 0.1f))

    ) {
        Column {
            Text(
                text = stringResource(id = R.string.about_employee_title),
                style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                modifier = Modifier.padding(top = 32.dp, start = 20.dp)
            )

            Row(modifier = Modifier.padding(top = 22.dp, start = 20.dp, end = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.employee_details_position_title),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = employee.position,
                    style = MaterialTheme.typography.h1.copy(fontSize = 17.sp),
                    color = MaterialTheme.colors.onSurface
                )
            }
            Row(modifier = Modifier.padding(top = 14.dp, start = 20.dp, end = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.employee_details_experience_title),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = stringResource(
                        id = R.string.employee_details_experience_text,
                        employee.experience
                    ),
                    style = MaterialTheme.typography.h1.copy(fontSize = 17.sp),
                    color = MaterialTheme.colors.onSurface
                )
            }

            Row(modifier = Modifier.padding(top = 14.dp, start = 20.dp, end = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.employee_details_department_title),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = employee.skills.first().name,
                    style = MaterialTheme.typography.h1.copy(fontSize = 17.sp),
                    color = MaterialTheme.colors.primary
                )
            }

            SmallProjectCard(
                project = employee.currentProject,
                modifier = Modifier.padding(vertical = 24.dp, horizontal = 20.dp),
                onClick = { onProjectCardClick(it) }
            )

            Text(
                text = pluralStringResource(
                    id = R.plurals.number_of_projects,
                    count = employee.projects.size,
                    employee.projects.size
                ),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(start = 20.dp)
            )

            Divider(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 32.dp),
                color = MaterialTheme.colors.background
            )

            Text(
                text = stringResource(id = R.string.employee_details_skills_title),
                style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 20.dp)
            )

            ChipGroup(
                skills = employee.skills.drop(1),
                modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 48.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeDetailsPreview() {
    SurfTeamTheme {
        EmployeeDetailsScreen(
            employeeId = employees.first().id
        )
    }
}