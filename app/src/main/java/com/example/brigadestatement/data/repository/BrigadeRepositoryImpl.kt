package com.example.brigadestatement.data.repository

import com.example.brigadestatement.data.local.dao.BrigadeDao
import com.example.brigadestatement.data.mapper.toBrigadeEntity
import com.example.brigadestatement.data.mapper.toEmployee
import com.example.brigadestatement.data.remote.BrigadeApi
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BrigadeRepositoryImpl(
    private val brigadeApi: BrigadeApi,
    private val brigadeDao: BrigadeDao
) : BrigadeRepository {

    override suspend fun getListBrigade(): Resource<List<Employee>> {
        return try {
            val result = brigadeApi.getListBrigade().listBrigade
            if (result.isNotEmpty()) {
                Resource.Success(result)
            } else {
                Resource.Error(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }

    //БД
    override suspend fun upsertEmployee(employee: Employee) {
        brigadeDao.upsertEmployee(employee.toBrigadeEntity())
    }

    override suspend fun updateEmployee(employee: Employee) {
        brigadeDao.updateEmployee(employee.toBrigadeEntity())
    }

    override suspend fun deleteEmployee(employee: Employee) {
        brigadeDao.deleteEmployee(employee.toBrigadeEntity())
    }

    override fun getAllBrigadeEmployees(): Flow<List<Employee?>> {
        return brigadeDao.getAllBrigadeEmployees()
            .map { listEmployees -> listEmployees.map { it?.toEmployee() } }
    }
}