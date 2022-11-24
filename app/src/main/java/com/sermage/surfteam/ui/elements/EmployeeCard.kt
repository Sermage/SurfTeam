package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sermage.surfteam.data.Skill
import com.sermage.surfteam.data.Skills
import com.sermage.surfteam.ui.theme.SurfTeamTheme


@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun EmployeeCard(
    modifier: Modifier = Modifier,
    employeeName: String,
    photoUrl: String,
    employeePosition: String,
    skills: List<Skill>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 10.dp,
        onClick = {}
    ) {
        ConstraintLayout(modifier = Modifier.padding(16.dp)) {
            val (name, photo, position) = createRefs()
            val skillsGroup = createRef()

            Text(
                text = employeeName,
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier.constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )
            Image(
                painter = rememberImagePainter(data = photoUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    }),
                contentDescription = "Employee photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(34.dp)
                    .constrainAs(photo) {
                        top.linkTo(name.bottom, margin = 12.dp)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = employeePosition,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.constrainAs(position) {
                    top.linkTo(name.bottom, margin = 12.dp)
                    start.linkTo(photo.end, margin = 16.dp)
                }
            )

            ChipGroup(skills = skills,
                modifier = Modifier.constrainAs(skillsGroup) {
                    top.linkTo(position.bottom, margin = 8.dp)
                    start.linkTo(position.start)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeCardPreview() {
    val photoUrl =
        "https://static.wikia.nocookie.net/reddeadredemption/images/5/52/RDR2_Arthur_Morgan_Default.jpg/revision/latest/scale-to-width-down/350?cb=20200602191534"
    val name = "Arthur Morgan"
    SurfTeamTheme {
        Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {
            EmployeeCard(
                employeeName = name,
                photoUrl = photoUrl,
                employeePosition = "Gunslinger",
                skills = Skills.items
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeCardDarkPreview() {
    val photoUrl =
        "https://static.wikia.nocookie.net/reddeadredemption/images/5/52/RDR2_Arthur_Morgan_Default.jpg/revision/latest/scale-to-width-down/350?cb=20200602191534"
    val name = "Arthur Morgan"
    SurfTeamTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {
            EmployeeCard(
                employeeName = name,
                photoUrl = photoUrl,
                employeePosition = "Gunslinger",
                skills = Skills.items
            )
        }

    }
}