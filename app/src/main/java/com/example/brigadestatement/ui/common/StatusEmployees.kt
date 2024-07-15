package com.example.brigadestatement.ui.common

enum class StatusRed(val value: String) {
    WEEKEND("Выходной"),
    DISEASE("Больничный"),
    VACATION("Отпуск"),
    HOLIDAY("Праздник")
}

enum class StatusGreen(val value: String) {
    ON_SHIFT("На смене"),
    WORKING_OVERTIME("Сверхурочные")
}

enum class StatusGray(val value: String) {
    UNKNOWN_CAUSES("Неизвестная причина отсутствия")
}