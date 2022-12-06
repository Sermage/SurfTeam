package com.sermage.surfteam.data

import androidx.compose.runtime.Composable
import com.sermage.surfteam.R
import com.sermage.surfteam.ui.screens.main.tabs.AboutAppTabContent
import com.sermage.surfteam.ui.screens.main.tabs.EmployeesTabContent
import com.sermage.surfteam.ui.screens.main.tabs.ProjectsTabContent

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(val title: Int, val screen: ComposableFun) {
    object EmployeesScreenTab :
        TabItem(
            title = R.string.employees_screen_tab_title,
            screen = { EmployeesTabContent(employees) })

    object ProjectsScreenTab :
        TabItem(title = R.string.projects_screen_tab_title, screen = { ProjectsTabContent() })

    object AboutAppTab :
        TabItem(title = R.string.about_app_screen_tab_title, screen = { AboutAppTabContent() })
}
