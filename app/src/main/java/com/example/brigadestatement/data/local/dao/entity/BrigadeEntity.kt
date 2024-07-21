package com.example.brigadestatement.data.local.dao.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BrigadeEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val plotNumber: String,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val status: String,
    val position: String,
    val date: String,
    val dateMs: Long
)
