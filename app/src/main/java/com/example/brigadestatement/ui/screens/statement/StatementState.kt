package com.example.brigadestatement.ui.screens.statement

import com.example.brigadestatement.domain.model.BrigadeEmployee

data class StatementState(
    val currentBrigade: List<BrigadeEmployee?> = emptyList(),
    val allBrigades: List<BrigadeEmployee?> = emptyList(),
    val filteredBrigades: List<BrigadeEmployee?> = emptyList(),
    val filteredIsEmpty: Boolean = false
)