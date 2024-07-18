package com.example.brigadestatement.data.repository

import com.example.brigadestatement.data.local.dao.BrigadeDao
import com.example.brigadestatement.data.mapper.toBrigadeEmployee
import com.example.brigadestatement.data.mapper.toBrigadeEntity
import com.example.brigadestatement.data.remote.BrigadeApi
import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BrigadeRepositoryImpl(
    private val brigadeApi: BrigadeApi,
    private val brigadeDao: BrigadeDao
) : BrigadeRepository {

    override suspend fun getEmployees(): Resource<List<Employee>> {
        return try {
            val result = brigadeApi.getEmployees()
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

    override suspend fun getListBrigade(): Resource<List<BrigadeEmployee>> {
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
    override suspend fun upsertEmployee(brigadeEmployee: BrigadeEmployee) {
        brigadeDao.upsertEmployee(brigadeEmployee.toBrigadeEntity())
    }

    override suspend fun updateBrigadeEmployee(id: Int, status: String) {
        brigadeDao.updateBrigadeEmployee(id = id, status = status)
    }

    override suspend fun deleteEmployee(brigadeEmployee: BrigadeEmployee) {
        brigadeDao.deleteEmployee(brigadeEmployee.toBrigadeEntity())
    }

    override suspend fun insertBrigadeEmployees(employees: List<BrigadeEmployee>) {
        brigadeDao.insertBrigade(employees.map { it.toBrigadeEntity() })
    }

    override fun getAllBrigadeEmployees(): Flow<List<BrigadeEmployee?>> {
        return brigadeDao.getAllBrigadeEmployees()
            .map { listEmployees -> listEmployees.map { it?.toBrigadeEmployee() } }
    }

    override fun getBrigadeEmployees(date: String): Flow<List<BrigadeEmployee>> {
        return brigadeDao.getBrigadeEmployees(date)
            .map { employees -> employees.map { it.toBrigadeEmployee() } }
    }
}