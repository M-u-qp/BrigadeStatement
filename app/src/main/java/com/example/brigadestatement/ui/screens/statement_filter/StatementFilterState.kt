package com.example.brigadestatement.ui.screens.statement_filter

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.model.Employee

data class StatementFilterState(
    val allEmployees: List<Employee> = emptyList(),
    val employeesFiltered: List<BrigadeEmployee> = emptyList(),
    val selectStatus: List<String> = emptyList(),
    val selectEmployees: List<Employee> = emptyList(),
    val dateRange: LongRange = 0L..1L,

    val showDialogDates: Boolean = false,
    val showDialogEmployees: Boolean = false,
    val showDialogStatus: Boolean = false,
)
