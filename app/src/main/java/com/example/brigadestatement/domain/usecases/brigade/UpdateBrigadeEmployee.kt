package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.repository.BrigadeRepository

class UpdateBrigadeEmployee(
    private val brigadeRepository: BrigadeRepository
) {
    suspend operator fun invoke(id: Int, status: String) {
        brigadeRepository.updateBrigadeEmployee(id = id, status = status)
    }
}