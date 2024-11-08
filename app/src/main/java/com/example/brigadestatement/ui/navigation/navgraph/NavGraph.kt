package com.example.brigadestatement.ui.navigation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.brigadestatement.R
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.navigation.components.BottomNavigation
import com.example.brigadestatement.ui.navigation.components.BottomNavigationItem
import com.example.brigadestatement.ui.screens.brigade.BrigadeScreen
import com.example.brigadestatement.ui.screens.brigade.BrigadeViewModel
import com.example.brigadestatement.ui.screens.employees.EmployeesScreen
import com.example.brigadestatement.ui.screens.employees.EmployeesViewModel
import com.example.brigadestatement.ui.screens.info_employee.InfoEmployeeScreen
import com.example.brigadestatement.ui.screens.statement.StatementScreen
import com.example.brigadestatement.ui.screens.statement.StatementViewModel
import com.example.brigadestatement.ui.screens.statement_filter.FilterData
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterScreen
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterViewModel
import com.example.brigadestatement.ui.util.Constants.EMPLOYEE
import com.example.brigadestatement.ui.util.Constants.FILTER_DATA

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
                    val viewModel: BrigadeViewModel = hiltViewModel()
                    val state = viewModel.state.collectAsState().value
                    BrigadeScreen(state = state)
                }
                composable(route = Route.StatementScreen.route) {
                    val viewModel: StatementViewModel = hiltViewModel()
                    val state = viewModel.state.collectAsState().value
                    if (navController.previousBackStackEntry?.destination?.route == Route.StatementFilterScreen.route) {
                        navController.previousBackStackEntry?.savedStateHandle?.get<FilterData?>(
                            FILTER_DATA
                        )
                            ?.let { filterData ->
                                StatementScreen(
                                    viewModel = viewModel,
                                    state = state,
                                    navigateToFilter = { navController.navigate(route = Route.StatementFilterScreen.route) },
                                    filterData = filterData
                                )
                            }
                    } else {
                        StatementScreen(
                            viewModel = viewModel,
                            state = state,
                            navigateToFilter = { navController.navigate(route = Route.StatementFilterScreen.route) },
                            filterData = null
                        )
                    }

                }
                composable(route = Route.EmployeesScreen.route) {
                    val viewModel: EmployeesViewModel = hiltViewModel()
                    val state = viewModel.state.collectAsState().value
                    EmployeesScreen(
                        state = state,
                        navigateToInfoEmployee = { employee ->
                            navigateToInfoEmployee(
                                navController = navController,
                                employee = employee
                            )
                        }
                    )
                }
                composable(route = Route.StatementFilterScreen.route) {
                    val viewModel: StatementFilterViewModel = hiltViewModel()
                    val state = viewModel.state.collectAsState().value
                    StatementFilterScreen(
                        viewModel = viewModel,
                        state = state,
                        navigateToStatement = { filterData ->
                            navigateToStatement(
                                navController = navController,
                                filterData = filterData
                            )
                        },
                        navigateUp = { navController.navigateUp() }
                    )
                }
                composable(route = Route.InfoEmployeeScreen.route) {
                    navController.previousBackStackEntry?.savedStateHandle?.get<Employee?>(EMPLOYEE)
                        ?.let { employee ->
                            InfoEmployeeScreen(
                                employee = employee,
                                navigateUp = { navController.navigateUp() }
                            )
                        }
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

private fun navigateToStatement(navController: NavController, filterData: FilterData?) {
    navController.currentBackStackEntry?.savedStateHandle?.set(FILTER_DATA, filterData)
    navController.navigate(route = Route.StatementScreen.route)
}

private fun navigateToInfoEmployee(navController: NavController, employee: Employee?) {
    navController.currentBackStackEntry?.savedStateHandle?.set(EMPLOYEE, employee)
    navController.navigate(route = Route.InfoEmployeeScreen.route)
}