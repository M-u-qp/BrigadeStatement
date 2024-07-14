package com.example.brigadestatement.domain.usecases.db

data class BrigadeUseCases(
    val upsertEmployee: UpsertEmployee,
    val updateEmployee: UpdateEmployee,
    val deleteEmployee: DeleteEmployee,
    val getAllBrigadeEmployees: GetAllBrigadeEmployees
)