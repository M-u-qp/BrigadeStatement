package com.example.brigadestatement.data.remote

import com.example.brigadestatement.data.remote.dto.BrigadeResponse
import com.example.brigadestatement.domain.model.Employee
import kotlinx.coroutines.delay

class BrigadeApiImpl : BrigadeApi {
    override suspend fun getListBrigade(): BrigadeResponse {
        delay(1000)
        return BrigadeResponse(
            listOf(
                Employee(
                    id = 1,
                    firstName = "Иван",
                    lastName = "Иванов",
                    patronymic = "Иванович",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "слесарь",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 2,
                    firstName = "Петр",
                    lastName = "Петров",
                    patronymic = "Петрович",
                    status = "Больничный",
                    age = null,
                    address = null,
                    position = "водитель",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 3,
                    firstName = "Игорь",
                    lastName = "Игорев",
                    patronymic = "Игоревич",
                    status = "Неизвестно",
                    age = null,
                    address = null,
                    position = "рабочий",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 4,
                    firstName = "Анна",
                    lastName = "Иванова",
                    patronymic = "Ивановна",
                    status = "Отпуск",
                    age = null,
                    address = null,
                    position = "швея",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 5,
                    firstName = "Татьяна",
                    lastName = "Петрова",
                    patronymic = "Петровна",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "фельдшер",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 6,
                    firstName = "Олег",
                    lastName = "Сидоров",
                    patronymic = "Сидорович",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "технолог",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 7,
                    firstName = "Мария",
                    lastName = "Сидорова",
                    patronymic = "Сидоровна",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "технолог",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 8,
                    firstName = "Василий",
                    lastName = "Васин",
                    patronymic = "Васильевич",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "слесарь",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 9,
                    firstName = "Марина",
                    lastName = "Васина",
                    patronymic = "Васильевна",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "фасовщица",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 10,
                    firstName = "Александр",
                    lastName = "Александрин",
                    patronymic = "Александрович",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "грузчик",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 11,
                    firstName = "Дмитрий",
                    lastName = "Дмитров",
                    patronymic = "Дмитриевич",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "грузчик",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
                Employee(
                    id = 12,
                    firstName = "Михаил",
                    lastName = "Мишин",
                    patronymic = "Михайлович",
                    status = "На смене",
                    age = null,
                    address = null,
                    position = "разнорабочий",
                    division = null,
                    plotNumber = null,
                    employeeNumber = null,
                    phoneNumber = null
                ),
            )
        )
    }
}