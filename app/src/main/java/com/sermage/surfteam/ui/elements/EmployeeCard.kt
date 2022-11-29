package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Employee
import com.sermage.surfteam.data.Skills
import com.sermage.surfteam.ui.theme.SurfTeamTheme


@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun EmployeeCard(
    modifier: Modifier = Modifier,
    employee: Employee,
    onCardClick: (Employee) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        elevation = 10.dp,
        onClick = { onCardClick(employee) }
    ) {
        ConstraintLayout(modifier = Modifier.padding(16.dp)) {
            val (name, photo, position) = createRefs()
            val skillsGroup = createRef()

            Text(
                text = employee.name,
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier.constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )
            Image(
                painter = rememberImagePainter(data = employee.photoUrl,
                    builder = {
                        placeholder(R.drawable.android_logo_night)
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
                text = employee.position,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.constrainAs(position) {
                    top.linkTo(name.bottom, margin = 12.dp)
                    start.linkTo(photo.end, margin = 16.dp)
                }
            )

            ChipGroup(skills = employee.skills,
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
    val employee = Employee(
        name = "Arthur Morgan",
        photoUrl = photoUrl,
        position = "Gunslinger",
        skills = Skills.android
    )
    SurfTeamTheme {
        Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {
            EmployeeCard(employee = employee)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeCardDarkPreview() {
    val photoUrl =
        "https://static.wikia.nocookie.net/reddeadredemption/images/5/52/RDR2_Arthur_Morgan_Default.jpg/revision/latest/scale-to-width-down/350?cb=20200602191534"
    val employee = Employee(
        name = "Arthur Morgan",
        photoUrl = photoUrl,
        position = "Gunslinger",
        skills = Skills.android
    )
    SurfTeamTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {
            EmployeeCard(employee = employee)
        }
    }
}