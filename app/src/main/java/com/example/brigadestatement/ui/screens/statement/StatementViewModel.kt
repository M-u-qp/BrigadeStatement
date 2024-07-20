package com.example.brigadestatement.ui.screens.statement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import com.example.brigadestatement.ui.screens.statement_filter.FilterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatementViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(StatementState())
    val state: StateFlow<StatementState> = _state

    init {
        getAllBrigadeEmployees()
    }

    suspend fun getBrigadeEmployees(date: String) {
        val result = brigadeUseCases.getBrigadeEmployees(date).first()
        if (result.isNotEmpty()) {
            _state.value = _state.value.copy(currentBrigade = result)
        }
    }

      private fun getAllBrigadeEmployees() {
          viewModelScope.launch {
              val result = brigadeUseCases.getAllBrigadeEmployees().first()
              if (result.isNotEmpty()) {
                  _state.value = _state.value.copy(allBrigades = result)
              }
          }
    }

    fun getFilteredBrigades(filterData: FilterData) {
        val filteredBrigades = state.value.allBrigades.filter { brigadeEmployee ->
            brigadeEmployee?.status in filterData.selectedStatus &&
                    "${brigadeEmployee?.firstName} ${brigadeEmployee?.lastName}" in filterData.selectedEmployees &&
                    brigadeEmployee?.date.toString() in filterData.selectedDates
        }
        _state.value = _state.value.copy(
            filteredBrigades = filteredBrigades,
            filteredIsEmpty = true
        )
    }
}