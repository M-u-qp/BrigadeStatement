package com.example.brigadestatement.ui.screens.statement_filter

import androidx.lifecycle.ViewModel
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StatementFilterViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
): ViewModel() {

    private val _state = MutableStateFlow(StatementFilterState())
    val state: StateFlow<StatementFilterState> = _state

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
}