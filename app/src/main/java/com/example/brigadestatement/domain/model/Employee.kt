package com.example.brigadestatement.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val patronymic: String?,
    val age: Int?,
    val address: Address?,
    val position: String,
    val division: String?,
    val plotNumber: String?,
    val employeeNumber: String?,
    val phoneNumber: String?,
    val photo: String?
): Parcelable

@Parcelize
data class Address(
    val country: String,
    val city: String,
    val street: String,
    val home: Int,
    val corpus: String?,
    val apartment: Int?
): Parcelable
