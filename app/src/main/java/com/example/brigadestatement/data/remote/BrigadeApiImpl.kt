package com.example.brigadestatement.data.remote

import com.example.brigadestatement.data.remote.dto.BrigadeResponse
import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.ui.common.currentDate

class BrigadeApiImpl : BrigadeApi {
    override suspend fun getListBrigade(): BrigadeResponse {
        val date = currentDate()

        return BrigadeResponse(
            listOf(
                BrigadeEmployee(
                    plotNumber = "1234501",
                    firstName = "Иван",
                    lastName = "Иванов",
                    patronymic = "Иванович",
                    status = "На смене",
                    position = "слесарь",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234502",
                    firstName = "Петр",
                    lastName = "Петров",
                    patronymic = "Петрович",
                    status = "Больничный",
                    position = "водитель",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234503",
                    firstName = "Игорь",
                    lastName = "Игорев",
                    patronymic = "Игоревич",
                    status = "Неизвестно",
                    position = "рабочий",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234504",
                    firstName = "Анна",
                    lastName = "Иванова",
                    patronymic = "Ивановна",
                    status = "Отпуск",
                    position = "швея",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234505",
                    firstName = "Татьяна",
                    lastName = "Петрова",
                    patronymic = "Петровна",
                    status = "На смене",
                    position = "фельдшер",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234506",
                    firstName = "Олег",
                    lastName = "Сидоров",
                    patronymic = "Сидорович",
                    status = "На смене",
                    position = "технолог",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234507",
                    firstName = "Мария",
                    lastName = "Сидорова",
                    patronymic = "Сидоровна",
                    status = "На смене",
                    position = "технолог",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234508",
                    firstName = "Василий",
                    lastName = "Васин",
                    patronymic = "Васильевич",
                    status = "На смене",
                    position = "слесарь",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234509",
                    firstName = "Марина",
                    lastName = "Васина",
                    patronymic = "Васильевна",
                    status = "На смене",
                    position = "фасовщица",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234510",
                    firstName = "Александр",
                    lastName = "Александрин",
                    patronymic = "Александрович",
                    status = "На смене",
                    position = "грузчик",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234511",
                    firstName = "Дмитрий",
                    lastName = "Дмитров",
                    patronymic = "Дмитриевич",
                    status = "На смене",
                    position = "грузчик",
                    date = date
                ),
                BrigadeEmployee(
                    plotNumber = "1234512",
                    firstName = "Михаил",
                    lastName = "Мишин",
                    patronymic = "Михайлович",
                    status = "На смене",
                    position = "разнорабочий",
                    date = date
                ),
            )
        )
    }
}