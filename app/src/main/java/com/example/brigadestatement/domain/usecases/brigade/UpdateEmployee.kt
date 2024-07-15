package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository

class UpdateEmployee(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(employee: Employee) {
        brigadeRepository.updateEmployee(employee)
    }
}