package com.example.brigadestatement.ui.screens.statement

import com.example.brigadestatement.domain.model.BrigadeEmployee

data class StatementState(
    val currentBrigade: List<BrigadeEmployee?> = emptyList(),

)