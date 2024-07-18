package com.example.brigadestatement.data.remote

import com.example.brigadestatement.data.remote.dto.BrigadeResponse
import com.example.brigadestatement.domain.model.Employee

interface BrigadeApi {

    suspend fun getListBrigade(): BrigadeResponse

    suspend fun getEmployees(): List<Employee>
}