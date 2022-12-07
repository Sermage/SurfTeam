package com.sermage.surfteam.ui.screens.project_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sermage.surfteam.R
import com.sermage.surfteam.ui.theme.Orange
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun ProjectDurationCard(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Card(
            border = BorderStroke(1.dp, color = MaterialTheme.colors.background),
            elevation = 0.dp
        ) {

            Column(modifier = Modifier) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
                    )
                ) {
                    Text(
                        text = "31",
                        style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                        color = Orange,
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 12.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                    )
                ) {
                    Text(
                        text = "день",
                        style = MaterialTheme.typography.body1,
                        color = Orange,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }

        Text(
            text = stringResource(id = R.string.project_details_project_duration_title),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(start = 20.dp)
                .align(CenterVertically)
        )
    }
}

@Preview
@Composable
fun ProjectDurationPreview() {
    SurfTeamTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            ProjectDurationCard()
        }
    }
}