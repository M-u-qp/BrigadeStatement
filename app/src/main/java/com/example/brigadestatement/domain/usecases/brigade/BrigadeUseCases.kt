package com.example.brigadestatement.domain.usecases.brigade

data class BrigadeUseCases(
    val upsertEmployee: UpsertEmployee,
    val updateBrigadeEmployee: UpdateBrigadeEmployee,
    val deleteEmployee: DeleteEmployee,
    val getAllBrigadeEmployees: GetAllBrigadeEmployees,
    val getBrigade: GetBrigade,
    val getBrigadeEmployees: GetBrigadeEmployees,
    val insertBrigade: InsertBrigade,
    )