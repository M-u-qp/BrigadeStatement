package com.example.brigadestatement.ui.screens.statement

import androidx.lifecycle.ViewModel
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@HiltViewModel
class StatementViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
): ViewModel() {

    private val _state = MutableStateFlow(StatementState())
    val state: StateFlow<StatementState> = _state

    suspend fun getBrigadeEmployees(date: String) {
        val result = brigadeUseCases.getBrigadeEmployees(date).first()
        if (result.isNotEmpty()){
            _state.value = _state.value.copy(currentBrigade = result)
        }
    }
}