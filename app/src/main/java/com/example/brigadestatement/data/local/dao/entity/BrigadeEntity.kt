package com.example.brigadestatement.data.local.dao.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BrigadeEntity(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val status: String,
    val position: String
)
