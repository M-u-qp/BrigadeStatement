package com.example.brigadestatement.ui.common

enum class StatusRed(val value: String) {
    WEEKEND(value = "Выходной"),
    DISEASE(value = "Больничный"),
    VACATION(value = "Отпуск"),
    HOLIDAY(value = "Праздник")
}

enum class StatusGreen(val value: String) {
    ON_SHIFT(value = "На смене"),
    WORKING_OVERTIME(value = "Сверхурочные")
}

enum class StatusGray(val value: String) {
    UNKNOWN_CAUSES(value = "Неизвестно")
}