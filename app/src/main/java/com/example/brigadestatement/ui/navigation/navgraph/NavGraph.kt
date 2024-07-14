package com.example.brigadestatement.ui.navigation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.navigation.components.BottomNavigation
import com.example.brigadestatement.ui.navigation.components.BottomNavigationItem
import com.example.brigadestatement.ui.screens.brigade.BrigadeScreen
import com.example.brigadestatement.ui.screens.employees.EmployeesScreen
import com.example.brigadestatement.ui.screens.statement.StatementScreen

@Composable
fun NavGraph(
    startDestination: String
) {

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    selectedItem = remember(key1 = backstackState) {
        when (backstackState?.destination?.route) {
            Route.BrigadeScreen.route -> 0
            Route.StatementScreen.route -> 1
            Route.EmployeesScreen.route -> 2
            else -> 0
        }
    }

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(R.drawable.ic_brigade, text = "Бригада"),
            BottomNavigationItem(R.drawable.ic_statement, text = "Табель"),
            BottomNavigationItem(R.drawable.ic_employees, text = "Сотрудники"),
        )
    }

    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Route.BrigadeScreen.route ||
                backstackState?.destination?.route == Route.StatementScreen.route ||
                backstackState?.destination?.route == Route.EmployeesScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                BottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> {
                                navigateToTab(
                                    navController = navController,
                                    route = Route.BrigadeScreen.route
                                )
                            }
                            1 -> {
                                navigateToTab(
                                    navController = navController,
                                    route = Route.StatementScreen.route
                                )
                            }
                            2 -> {
                                navigateToTab(
                                    navController = navController,
                                    route = Route.EmployeesScreen.route
                                )
                            }
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            navigation(
                route = Route.AppStartNavigation.route,
                startDestination = Route.BrigadeScreen.route
            ) {
                composable(route = Route.BrigadeScreen.route) {
                    BrigadeScreen()
                }
                composable(route = Route.StatementScreen.route) {
                    StatementScreen()
                }
                composable(route = Route.EmployeesScreen.route) {
                    EmployeesScreen()
                }
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { brigadeScreen ->
            popUpTo(brigadeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}