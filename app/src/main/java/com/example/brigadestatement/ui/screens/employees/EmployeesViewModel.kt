package com.example.brigadestatement.ui.screens.employees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brigadestatement.domain.usecases.employees.EmployeesUseCases
import com.example.brigadestatement.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeesViewModel @Inject constructor(
    private val employeesUseCases: EmployeesUseCases
): ViewModel() {

    private val _state = MutableStateFlow(EmployeesState())
    val state: StateFlow<EmployeesState> = _state

    init {
        getEmployees()
    }

    private fun getEmployees() {
        viewModelScope.launch {
            if (state.value.employees.isEmpty()) {
                when (val employees = employeesUseCases.getEmployees()) {
                    is Resource.Success -> {
                        employees.data?.let {
                            _state.value = _state.value.copy(
                                employees = it,
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
}