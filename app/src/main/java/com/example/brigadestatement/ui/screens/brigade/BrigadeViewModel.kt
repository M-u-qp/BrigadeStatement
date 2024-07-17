package com.example.brigadestatement.ui.screens.brigade

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import com.example.brigadestatement.domain.utils.Resource
import com.example.brigadestatement.ui.common.currentDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BrigadeViewModel @Inject constructor(
    private val brigadeUseCases: BrigadeUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(BrigadeState())
    val state: StateFlow<BrigadeState> = _state


    init {
        viewModelScope.launch {
            getBrigade()
        }
    }

    //Получить текущую бригаду с сервера
    private suspend fun getBrigade() {
        if (state.value.listBrigade.isEmpty()) {
            when (val listBrigade = brigadeUseCases.getBrigade()) {
                is Resource.Success -> {
                    listBrigade.data?.let {
                        _state.value = _state.value.copy(
                            listBrigade = it,
                            errorBrigade = null
                        )
                    }
                }

                is Resource.Error -> {
                    _state.value =
                        _state.value.copy(errorBrigade = listBrigade.exception.toString())
                }

                else -> Unit
            }
        }
    }

    //Получить текущую бригаду за сегодняшний день
    suspend fun getBrigadeEmployees(date: String) {
        val result = brigadeUseCases.getBrigadeEmployees(date).first()
        if (result.isNotEmpty()) {
            _state.value = _state.value.copy(currentBrigade = result)
        }
        _state.value = _state.value.copy(changedStatusEmployee = false)
    }

    //Отправить табель
    suspend fun sendStatement() {
        if (state.value.currentBrigade.isEmpty()) {
            brigadeUseCases.insertBrigade(state.value.listBrigade)
        } else {
            state.value.currentBrigade.forEach {
                brigadeUseCases.updateBrigadeEmployee(id = it.id, status = it.status)
            }
        }
        getBrigadeEmployees(currentDate())
        _state.value = _state.value.copy(changedStatusEmployee = false)
    }

    fun updateChoiceGoodOrBadStatus(choice: Boolean) {
        _state.value = _state.value.copy(goodOrBadStatus = choice)
    }

    fun updateVisibleDialogStatus(show: Boolean) {
        _state.value = _state.value.copy(showDialogStatus = show)
    }

    fun updateCurrentIndex(index: Int) {
        _state.value = _state.value.copy(currentIndex = index)
    }

    fun updateStatusEmployee(status: String) {
        val index = state.value.currentIndex
        if (state.value.currentBrigade.isEmpty()) {
            val updatedList = _state.value.listBrigade.toMutableList()
            updatedList[index] = updatedList[index].copy(status = status)
            _state.value = _state.value.copy(
                listBrigade = updatedList
            )
        } else {
            val updatedList = _state.value.currentBrigade.toMutableList()
            updatedList[index] = updatedList[index].copy(status = status)
            _state.value = _state.value.copy(
                currentBrigade = updatedList
            )
        }
        _state.value = _state.value.copy(changedStatusEmployee = true)
    }
}