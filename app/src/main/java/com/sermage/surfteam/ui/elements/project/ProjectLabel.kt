package com.sermage.surfteam.ui.elements.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sermage.surfteam.ui.theme.Blue
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.sermage.surfteam.ui.theme.White

@Composable
fun ProjectLabel(
    modifier: Modifier = Modifier,
    color: Color = Blue,
    projectName: String
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 12.dp,
                    bottomEnd = 12.dp,
                    bottomStart = 12.dp
                )
            )
    ) {
        Text(
            text = projectName.first().uppercase(),
            style = MaterialTheme.typography.h1.copy(fontSize = 20.sp),
            color = White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectLabelPreview() {
    SurfTeamTheme() {
        ProjectLabel(projectName = "Infijoy")
    }
}