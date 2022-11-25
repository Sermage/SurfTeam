package com.sermage.surfteam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.R
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.surf_logo
                ),
                contentDescription = "Surf logo",
                modifier = modifier
                    .align(Alignment.TopStart)
                    .padding(top = 8.dp, start = 20.dp)
                    .size(58.dp, 40.dp)
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 20.dp)
                    .size(40.dp),
                contentPadding = PaddingValues(10.dp),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    tint = MaterialTheme.colors.onSurface,
                    contentDescription = "Search icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        val titles = listOf("СОТРУДНИКИ", "ПРОЕКТЫ", "О ПРИЛОЖЕНИИ")
        var selectedTabState by remember { mutableStateOf(0) }
        ScrollableTabRow(
            modifier = Modifier.padding(start = 20.dp, top = 40.dp),
            selectedTabIndex = selectedTabState,
            backgroundColor = Color.Transparent,
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabState == index,
                    onClick = { selectedTabState = index },
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = MaterialTheme.colors.onBackground
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    SurfTeamTheme {
        MainScreen()
    }
}

@Preview
@Composable
fun MainScreenDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        MainScreen()
    }
}