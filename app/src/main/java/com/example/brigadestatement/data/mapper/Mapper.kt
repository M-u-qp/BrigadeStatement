package com.example.brigadestatement.data.mapper

import com.example.brigadestatement.data.local.dao.entity.BrigadeEntity
import com.example.brigadestatement.domain.model.BrigadeEmployee

fun BrigadeEmployee.toBrigadeEntity(): BrigadeEntity {
    return BrigadeEntity(
        id = id,
        plotNumber = plotNumber,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic,
        status = status,
        position = position,
        date = date,
    )
}

fun BrigadeEntity.toBrigadeEmployee(): BrigadeEmployee {
    return BrigadeEmployee(
        id = id,
        plotNumber = plotNumber,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic,
        status = status,
        position = position,
        date = date,
    )
}