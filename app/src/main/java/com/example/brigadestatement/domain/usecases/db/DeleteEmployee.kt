package com.example.brigadestatement.domain.usecases.db

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository

class DeleteEmployee(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(employee: Employee) {
        brigadeRepository.deleteEmployee(employee)
    }
}