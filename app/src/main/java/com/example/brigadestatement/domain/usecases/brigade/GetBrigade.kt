package com.example.brigadestatement.domain.usecases.brigade

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.utils.Resource

class GetBrigade(
    private val brigadeRepository: BrigadeRepository
) {

    suspend operator fun invoke(): Resource<List<BrigadeEmployee>> {
        return brigadeRepository.getListBrigade()
    }
}