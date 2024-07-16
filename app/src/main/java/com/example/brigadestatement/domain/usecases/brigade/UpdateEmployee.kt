package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.repository.BrigadeRepository

class UpdateEmployee(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(brigadeEmployee: BrigadeEmployee) {
        brigadeRepository.updateEmployee(brigadeEmployee)
    }
}