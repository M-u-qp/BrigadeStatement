package com.example.brigadestatement.ui.screens.statement_filter

import com.example.brigadestatement.domain.model.Employee

data class StatementFilterState(
    val allEmployees: List<Employee> = emptyList(),
    val errorEmployees: String? = null,

    val selectStatus: List<String> = emptyList(),
    val selectEmployees: List<Employee> = emptyList(),
    val selectedDates: String = "",
    val dateRange: LongRange = 0L..0L,

    val showDialogDates: Boolean = false,
    val showDialogEmployees: Boolean = false,
    val showDialogStatus: Boolean = false,
)
