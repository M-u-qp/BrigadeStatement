package com.example.brigadestatement.domain.model

data class BrigadeEmployee(
    val id: Int = 0,
    val plotNumber: String,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val status: String,
    val position: String,
    val date: String,
)
