package com.example.brigadestatement.ui.screens.statement

import androidx.lifecycle.ViewModel
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import com.example.brigadestatement.ui.common.currentDate
import com.example.brigadestatement.ui.common.roundToDay
import com.example.brigadestatement.ui.screens.statement_filter.FilterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@HiltViewModel
class StatementViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(StatementState())
    val state: StateFlow<StatementState> = _state

    suspend fun getAllBrigadeEmployees() {
        val result = brigadeUseCases.getAllBrigadeEmployees().first()
        if (result.isNotEmpty()) {
            _state.value = _state.value.copy(allBrigades = result)
        }
    }

    fun getFilteredBrigades(filterData: FilterData?) {
        val filteredBrigades = state.value.allBrigades.filter { brigadeEmployee ->
            val fcs = "${brigadeEmployee?.firstName} ${brigadeEmployee?.lastName}"
            when {
                filterData != null -> {
                    when {
                        filterData.selectedStatus.isNotEmpty() && filterData.selectedEmployees.isNotEmpty() &&
                                filterData.selectedDateStart != 0L && filterData.selectedDateEnd != 0L
                        -> {

                            val startDate = roundToDay(filterData.selectedDateStart)
                            val endDate = roundToDay(filterData.selectedDateEnd)
                            val dateMs = brigadeEmployee?.let { roundToDay(it.dateMs) }
                            brigadeEmployee?.status in filterData.selectedStatus &&
                                    fcs in filterData.selectedEmployees &&
                                    dateMs in startDate..endDate
                        }

                        filterData.selectedEmployees.isNotEmpty() &&
                                filterData.selectedDateStart != 0L && filterData.selectedDateEnd != 0L -> {

                            val startDate = roundToDay(filterData.selectedDateStart)
                            val endDate = roundToDay(filterData.selectedDateEnd)
                            val dateMs = brigadeEmployee?.let { roundToDay(it.dateMs) }
                            fcs in filterData.selectedEmployees &&
                                    dateMs in startDate..endDate
                        }

                        filterData.selectedStatus.isNotEmpty() &&
                                filterData.selectedDateStart != 0L && filterData.selectedDateEnd != 0L -> {

                            val startDate = roundToDay(filterData.selectedDateStart)
                            val endDate = roundToDay(filterData.selectedDateEnd)
                            val dateMs = brigadeEmployee?.let { roundToDay(it.dateMs) }
                            brigadeEmployee?.status in filterData.selectedStatus &&
                                    dateMs in startDate..endDate
                        }

                        filterData.selectedDateStart != 0L && filterData.selectedDateEnd != 0L -> {

                            val startDate = roundToDay(filterData.selectedDateStart)
                            val endDate = roundToDay(filterData.selectedDateEnd)
                            val dateMs = brigadeEmployee?.let { roundToDay(it.dateMs) }
                            dateMs in startDate..endDate
                        }
                        filterData.selectedEmployees.isNotEmpty() && filterData.selectedStatus.isNotEmpty() -> {
                            false
                        }
                        filterData.selectedEmployees.isNotEmpty() -> {
                            false
                        }
                        filterData.selectedStatus.isNotEmpty() -> {
                            false
                        }

                        else -> true
                    }
                }

                else -> true
            }

        }
        _state.value = _state.value.copy(
            filteredBrigades = filteredBrigades
        )
    }
}