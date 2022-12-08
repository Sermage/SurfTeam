package com.sermage.surfteam.data

import com.sermage.surfteam.R

sealed class TabItem(val title: Int) {
    object EmployeesScreenTab : TabItem(title = R.string.employees_screen_tab_title)

    object ProjectsScreenTab : TabItem(title = R.string.projects_screen_tab_title)

    object AboutAppTab : TabItem(title = R.string.about_app_screen_tab_title)
}
