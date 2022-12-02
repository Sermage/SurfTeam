package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.sermage.surfteam.data.TabItem
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.sermage.surfteam.utils.customTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        modifier = modifier.padding(top = 40.dp),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        edgePadding = 4.dp,
        divider = {},
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = MaterialTheme.colors.primary,
                height = 3.dp,
                modifier = Modifier
                    .customTabIndicatorOffset(
                        currentTabPosition = tabPositions[pagerState.currentPage],
                        tabWidth = 24.dp,
                    )
            )
        }
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Column(
                    Modifier
                        .padding(bottom = 12.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        Modifier
                            .size(12.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = stringResource(id = tabItem.title),
                        style = MaterialTheme.typography.h2,
                        letterSpacing = 2.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabsPreview() {
    val tabs = listOf(TabItem.EmployeesScreenTab, TabItem.ProjectsScreenTab, TabItem.AboutAppTab)
    SurfTeamTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Tabs(tabs = tabs, pagerState = rememberPagerState())
        }
    }
}