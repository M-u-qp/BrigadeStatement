package com.example.brigadestatement.ui.screens.brigade

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BrigadeViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(BrigadeState())
    val state: StateFlow<BrigadeState> = _state
}