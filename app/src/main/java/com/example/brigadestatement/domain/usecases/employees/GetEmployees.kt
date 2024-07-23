package com.example.brigadestatement.domain.usecases.employees

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.utils.Resource

class GetEmployees(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(): Resource<List<Employee>> {
        return brigadeRepository.getEmployees()
    }
}