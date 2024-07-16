package com.example.brigadestatement.ui.common

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun currentDate(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return currentDate.format(formatter)
}