package com.example.brigadestatement.data.remote.dto

import com.example.brigadestatement.domain.model.Employee

data class EmployeesResponse(
    val listEmployees: List<Employee>
)
