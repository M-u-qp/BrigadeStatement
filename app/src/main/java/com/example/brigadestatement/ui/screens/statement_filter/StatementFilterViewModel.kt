package com.example.brigadestatement.ui.screens.statement_filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import com.example.brigadestatement.domain.utils.Resource
import com.example.brigadestatement.ui.common.StatusGreen
import com.example.brigadestatement.ui.common.StatusRed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class StatementFilterViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(StatementFilterState())
    val state: StateFlow<StatementFilterState> = _state

    init {
        getEmployees()
        getAllStatus()
    }

    private fun getEmployees() {
        viewModelScope.launch {
            if (state.value.allEmployees.isEmpty()) {
                when (val employees = brigadeUseCases.getEmployees()) {
                    is Resource.Success -> {
                        employees.data?.let {
                            _state.value = _state.value.copy(
                                allEmployees = it,
                                errorEmployees = null
                            )
                        }
                    }

                    is Resource.Error -> {
                        _state.value =
                            _state.value.copy(errorEmployees = employees.exception.toString())
                    }

                    else -> Unit
                }
            }
        }
    }

    private fun getAllStatus() {
        val statusList: MutableList<String> = mutableListOf()
        statusList.addAll(StatusGreen.entries.map { it.value })
        statusList.addAll(StatusRed.entries.map { it.value })
        _state.value = _state.value.copy(allStatus = statusList)
    }

    fun updateVisibleDialogEmployees(show: Boolean) {
        _state.value = _state.value.copy(
            showDialogEmployees = show
        )
    }

    fun updateVisibleDialogDates(show: Boolean) {
        _state.value = _state.value.copy(
            showDialogDates = show
        )
    }

    fun updateVisibleDialogStatus(show: Boolean) {
        _state.value = _state.value.copy(
            showDialogStatus = show
        )
    }

    fun updateSelectedEmployees(employees: List<String>) {
        _state.value = _state.value.copy(selectEmployees = employees)
    }

    fun updateSelectedDates(selectedDate1: Long?, selectedDate2: Long?) {
        if (selectedDate1 != null && selectedDate2 != null) {
            _state.value = _state.value.copy(
                dateRange = if (selectedDate1 < selectedDate2) {
                    selectedDate1..selectedDate2
                } else {
                    selectedDate2..selectedDate1
                }
            )
        } else {
            val currentDate = System.currentTimeMillis()
            _state.value = _state.value.copy(
                dateRange = currentDate..currentDate
            )
        }
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val date1 = Instant.ofEpochMilli(state.value.dateRange.first)
            .atZone(ZoneId.systemDefault()).toLocalDate().format(formatter)
        val date2 = Instant.ofEpochMilli(state.value.dateRange.last)
            .atZone(ZoneId.systemDefault()).toLocalDate().format(formatter)
        _state.value = _state.value.copy(selectedDates = "$date1 - $date2")
    }

    fun updateSelectedStatus(selectedStatus: List<String>) {
        _state.value = _state.value.copy(selectStatus = selectedStatus)
    }

    fun updateFilterData() {

    }
}