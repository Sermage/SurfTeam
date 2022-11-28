package com.sermage.surfteam.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.sermage.surfteam.R
import com.sermage.surfteam.data.TabItem
import com.sermage.surfteam.settings.isDarkTheme
import com.sermage.surfteam.ui.elements.Tabs
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val currentTheme = settingsViewModel.themeState.collectAsState()
    SurfTeamTheme(darkTheme = currentTheme.value.isDarkTheme()) {

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
            val tabs = listOf(
                TabItem.EmployeesScreenTab, TabItem.ProjectsScreenTab, TabItem.AboutAppTab
            )
            val pagerState = rememberPagerState()
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(
                tabs = tabs,
                pagerState = pagerState,
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    SurfTeamTheme {
        MainScreen(navController = rememberNavController())
    }
}

@Preview
@Composable
fun MainScreenDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        MainScreen(navController = rememberNavController())
    }
}