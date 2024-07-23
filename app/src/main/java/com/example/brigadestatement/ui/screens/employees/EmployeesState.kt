package com.example.brigadestatement.ui.screens.employees

import com.example.brigadestatement.domain.model.Employee

data class EmployeesState(
    val employees: List<Employee?> = emptyList(),
    val errorEmployees: String? = null,
)