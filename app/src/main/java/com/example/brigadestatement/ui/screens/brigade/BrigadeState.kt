package com.example.brigadestatement.ui.screens.brigade

import com.example.brigadestatement.domain.model.Employee

data class BrigadeState(
    val listBrigade: List<Employee> = emptyList(),
    val errorBrigade: String? = null,
)