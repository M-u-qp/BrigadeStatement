package com.example.brigadestatement.ui.common

import com.example.brigadestatement.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//Текущая дата в формате 01.01.1991
fun currentDate(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return currentDate.format(formatter)
}

//Получить цвет контейнера или цвет грани, или иконку
fun getColorOrIcon(value: String, id: Int): Int {
   val result = when(value)  {
         in StatusGreen.entries.map { it.value } -> {
            when (id) {
                0 -> R.color.green_card
                1 -> R.color.green_border
                2 -> {
                    when (value) {
                        StatusGreen.ON_SHIFT.value -> R.drawable.ic_on_shift
                        StatusGreen.WORKING_OVERTIME.value -> R.drawable.ic_working_overtime
                        else -> 0
                    }
                }
                else -> 0
            }
        }
        in StatusRed.entries.map { it.value } -> {
            when(id) {
                0 -> R.color.red_card
                1 -> R.color.red_border
                2 -> {
                    when(value) {
                        StatusRed.WEEKEND.value -> R.drawable.ic_weekend
                        StatusRed.DISEASE.value -> R.drawable.ic_disease
                        StatusRed.VACATION.value -> R.drawable.ic_vacation
                        StatusRed.HOLIDAY.value -> R.drawable.ic_holiday
                        else -> 0
                    }
                }
                else -> 0
            }
        }
        in StatusGray.entries.map { it.value } -> {
            when(id) {
                0 -> R.color.gray_card
                1 -> R.color.gray_border
                2 -> {
                    when(value) {
                        StatusGray.UNKNOWN_CAUSES.value -> R.drawable.ic_unknown
                        else -> 0
                    }
                }
                else -> 0
            }
        }
       else -> 0
   }
    return result
}
