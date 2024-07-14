package com.example.brigadestatement.domain.repository

import com.example.brigadestatement.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface BrigadeRepository {

    suspend fun upsertEmployee(employee: Employee)
    suspend fun updateEmployee(employee: Employee)
    suspend fun deleteEmployee(employee: Employee)
    fun getAllBrigadeEmployees(): Flow<List<Employee?>>

}