package com.sermage.surfteam.ui.screens.project_details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.R
import com.sermage.surfteam.data.Participant
import com.sermage.surfteam.data.projects
import com.sermage.surfteam.ui.elements.project.AvatarRow
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun TeamCard(
    modifier: Modifier = Modifier,
    team: List<Participant>
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {
        AvatarRow(
            photos = team.map { it.photoUrl },
            isNumbersVisible = true,
            photoSize = 40
        )
        if (team.size > 3) {
            Text(
                text = stringResource(id = R.string.project_detaills_all_team, team.size),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(CenterVertically)
                    .weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "arrow right",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamCardPreview() {
    SurfTeamTheme {
        TeamCard(team = projects.first().participants)
    }
}