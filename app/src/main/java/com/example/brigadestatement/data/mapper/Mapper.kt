package com.example.brigadestatement.data.mapper

import com.example.brigadestatement.data.local.dao.entity.BrigadeEntity
import com.example.brigadestatement.domain.model.Employee

fun Employee.toBrigadeEntity(): BrigadeEntity {
    return BrigadeEntity(
        id = id,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic.toString(),
        status = status,
        position = position
    )
}

fun BrigadeEntity.toEmployee(): Employee {
    return Employee(
        id = id,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic,
        status = status,
        position = position,
        address = null,
        age = null,
        division = null,
        employeeNumber = null,
        phoneNumber = null,
        plotNumber = null
    )
}