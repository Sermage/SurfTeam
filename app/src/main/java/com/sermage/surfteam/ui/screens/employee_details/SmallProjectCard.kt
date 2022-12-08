package com.sermage.surfteam.ui.screens.employee_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Project
import com.sermage.surfteam.data.projects
import com.sermage.surfteam.ui.elements.project.ProjectLabel
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun SmallProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: (String) -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.medium
            )
            .clickable { onClick(project.name) }
    ) {
        val (label, name, currentProject, icon) = createRefs()
        ProjectLabel(projectName = project.name,
            modifier = Modifier.constrainAs(label) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top, margin = 17.dp)
                bottom.linkTo(parent.bottom, margin = 17.dp)
            })

        Text(
            text = project.name,
            style = MaterialTheme.typography.h1.copy(fontSize = 15.sp),
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(label.end, margin = 18.dp)
            }
        )
        Text(
            text = stringResource(id = R.string.employee_details_current_project_title),
            style = MaterialTheme.typography.body1.copy(fontSize = 13.sp),
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(currentProject) {
                top.linkTo(name.bottom, margin = 8.dp)
                start.linkTo(name.start)
            }
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "right arrow",
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, margin = 22.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SmallProjectCardPreview() {
    SurfTeamTheme {
        SmallProjectCard(project = projects.first())
    }
}