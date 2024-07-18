package com.example.brigadestatement.domain.repository

import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BrigadeRepository {

    suspend fun getEmployees(): Resource<List<Employee>>
    suspend fun getListBrigade(): Resource<List<BrigadeEmployee>>

    //БД
    suspend fun upsertEmployee(brigadeEmployee: BrigadeEmployee)
    suspend fun updateBrigadeEmployee(id: Int, status: String)
    suspend fun deleteEmployee(brigadeEmployee: BrigadeEmployee)
    suspend fun insertBrigadeEmployees(employees: List<BrigadeEmployee>)
    fun getAllBrigadeEmployees(): Flow<List<BrigadeEmployee?>>
    fun getBrigadeEmployees(date: String): Flow<List<BrigadeEmployee>>

}