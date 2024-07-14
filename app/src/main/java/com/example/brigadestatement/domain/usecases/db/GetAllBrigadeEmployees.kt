package com.example.brigadestatement.domain.usecases.db

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import kotlinx.coroutines.flow.Flow

class GetAllBrigadeEmployees(
    private val brigadeRepository: BrigadeRepository
) {
    operator fun invoke(): Flow<List<Employee?>> {
        return brigadeRepository.getAllBrigadeEmployees()
    }
}