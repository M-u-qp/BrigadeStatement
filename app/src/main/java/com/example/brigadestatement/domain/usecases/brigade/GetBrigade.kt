package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.utils.Resource

class GetBrigade(
    private val brigadeRepository: BrigadeRepository
) {

    suspend operator fun invoke(): Resource<List<Employee>> {
        return brigadeRepository.getListBrigade()
    }
}