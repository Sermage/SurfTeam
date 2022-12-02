package com.sermage.surfteam.data

data class Project(
    val name: String,
    val participants: List<Employee>
)

val projects = listOf(
    Project("Infijoy", employees.drop(2)),
    Project("Avengers", employees.drop(3)),
    Project("Beethoven", employees.drop(4)),
    Project("KFC", employees),
    Project("Unicredit", employees.drop(1))
)


