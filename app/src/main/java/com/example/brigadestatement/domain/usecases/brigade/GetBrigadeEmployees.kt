package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import kotlinx.coroutines.flow.Flow

class GetBrigadeEmployees(
    private val brigadeRepository: BrigadeRepository
) {
    operator fun invoke(date: String): Flow<List<BrigadeEmployee?>> {
        return brigadeRepository.getBrigadeEmployees(date = date)
    }
}