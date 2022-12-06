package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.data.Employee
import com.sermage.surfteam.data.employees
import com.sermage.surfteam.ui.elements.EmployeeCard
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun EmployeesTabContent(
    employees: List<Employee>,
    modifier: Modifier = Modifier,
    onEmployeeCardClick: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp, top = 12.dp)
    ) {
        items(employees) { employee ->
            EmployeeCard(employee = employee,
                onCardClick = { onEmployeeCardClick(it) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeesTabContentPreview() {
    SurfTeamTheme {
        EmployeesTabContent(employees = employees)
    }
}