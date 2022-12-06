package com.sermage.surfteam.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sermage.surfteam.data.TabItem
import com.sermage.surfteam.data.employees
import com.sermage.surfteam.ui.screens.main.tabs.AboutAppTabContent
import com.sermage.surfteam.ui.screens.main.tabs.EmployeesTabContent
import com.sermage.surfteam.ui.screens.main.tabs.ProjectsTabContent

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    pagerState: PagerState,
    onEmployeeCardClick: (String) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        count = tabs.size,
        modifier = modifier
    ) { page ->
        when (page) {
            0 -> EmployeesTabContent(
                employees = employees,
                onEmployeeCardClick = { onEmployeeCardClick(it) })
            1 -> ProjectsTabContent()
            2 -> AboutAppTabContent()
        }
    }
}