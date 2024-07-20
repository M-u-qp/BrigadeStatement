package com.example.brigadestatement.ui.screens.statement_filter

import com.example.brigadestatement.domain.model.Employee

data class StatementFilterState(
    val allEmployees: List<Employee> = emptyList(),
    val errorEmployees: String? = null,

    val selectStatus: List<String> = emptyList(),
    val selectEmployees: List<String> = emptyList(),
    val selectedDates: String = "",
    val dateRange: LongRange = 0L..0L,
    val allStatus: List<String> = emptyList(),

    val showDialogDates: Boolean = false,
    val showDialogEmployees: Boolean = false,
    val showDialogStatus: Boolean = false,
)

data class FilterData(
    val selectedEmployees: List<Employee>
)
