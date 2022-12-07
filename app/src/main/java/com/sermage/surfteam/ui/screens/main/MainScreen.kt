package com.sermage.surfteam.ui.screens.main

import androidx.activity.compose.BackHandler
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.sermage.surfteam.R
import com.sermage.surfteam.data.TabItem
import com.sermage.surfteam.settings.isDarkTheme
import com.sermage.surfteam.ui.elements.Tabs
import com.sermage.surfteam.ui.elements.common.ActionButton
import com.sermage.surfteam.ui.theme.LocalDrawableResources
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = hiltViewModel(),
    backClick: () -> Unit = {},
    onEmployeeCardClick: (String) -> Unit = {},
    onProjectCardClick: (String) -> Unit = {}
) {
    val currentTheme = settingsViewModel.themeState.collectAsState()

    BackHandler() {
        backClick()
    }
    SurfTeamTheme(
        darkTheme = currentTheme.value.isDarkTheme()
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
                        id = LocalDrawableResources.current.surfLogo
                    ),
                    contentDescription = "Surf logo",
                    modifier = modifier
                        .align(Alignment.TopStart)
                        .padding(top = 8.dp, start = 20.dp)
                        .size(58.dp, 40.dp)
                )

                ActionButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 20.dp),
                    iconRes = R.drawable.ic_search,
                    iconContentDescription = "Search icon"
                )
            }
            val tabs = listOf(
                TabItem.EmployeesScreenTab, TabItem.ProjectsScreenTab, TabItem.AboutAppTab
            )
            val pagerState = rememberPagerState()
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(
                tabs = tabs,
                pagerState = pagerState,
                modifier = Modifier.padding(top = 12.dp),
                onEmployeeCardClick = { onEmployeeCardClick(it) },
                onProjectCardClick = { onProjectCardClick(it) }
            )
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