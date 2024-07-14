package com.example.brigadestatement.ui.navigation.navgraph

sealed class Route(val route: String) {

    data object AppStartNavigation : Route(route = "appStartNavigation")
    data object BrigadeScreen : Route(route = "brigadeScreen")
    data object StatementScreen : Route(route = "statementScreen")
    data object EmployeesScreen : Route(route = "employeesScreen")
}