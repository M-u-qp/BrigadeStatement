package com.example.brigadestatement.domain.repository

import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BrigadeRepository {

    suspend fun getListBrigade(): Resource<List<Employee>>

    //БД
    suspend fun upsertEmployee(employee: Employee)
    suspend fun updateEmployee(employee: Employee)
    suspend fun deleteEmployee(employee: Employee)
    fun getAllBrigadeEmployees(): Flow<List<Employee?>>

}