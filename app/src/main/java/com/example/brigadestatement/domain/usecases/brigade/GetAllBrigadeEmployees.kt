package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import kotlinx.coroutines.flow.Flow

class GetAllBrigadeEmployees(
    private val brigadeRepository: BrigadeRepository
) {
    operator fun invoke(): Flow<List<BrigadeEmployee?>> {
        return brigadeRepository.getAllBrigadeEmployees()
    }
}