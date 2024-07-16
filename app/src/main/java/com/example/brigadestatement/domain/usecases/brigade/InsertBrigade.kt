package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.repository.BrigadeRepository

class InsertBrigade(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(employees: List<BrigadeEmployee>) {
        brigadeRepository.insertBrigadeEmployees(employees)
    }
}