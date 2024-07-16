package com.example.brigadestatement.ui.screens.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee

data class BrigadeState(
    val listBrigade: List<BrigadeEmployee> = emptyList(),
    val errorBrigade: String? = null,
    val showDialogStatus: Boolean = false,
    val goodOrBadStatus: Boolean = false,
    val currentBrigade: List<BrigadeEmployee?> = emptyList(),

)