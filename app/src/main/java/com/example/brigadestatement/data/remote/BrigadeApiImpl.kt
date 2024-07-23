package com.example.brigadestatement.data.remote

import com.example.brigadestatement.data.remote.dto.BrigadeResponse
import com.example.brigadestatement.domain.model.Address
import com.example.brigadestatement.domain.model.BrigadeEmployee
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.common.currentDateMs
import com.example.brigadestatement.ui.common.currentDate

class BrigadeApiImpl : BrigadeApi {

    override suspend fun getEmployees(): List<Employee> {
        return listOf(
            Employee(
                plotNumber = "1234501",
                firstName = "Иван",
                lastName = "Иванов",
                patronymic = "Иванович",
                position = "слесарь",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Ленина",
                    home = 33,
                    corpus = "А",
                    apartment = 109
                ),
                age = 45,
                division = "Мастерская",
                employeeNumber = "R001",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234502",
                firstName = "Петр",
                lastName = "Петров",
                patronymic = "Петрович",
                position = "водитель",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Бусыгина",
                    home = 36,
                    corpus = null,
                    apartment = 72
                ),
                age = 33,
                division = "Гараж",
                employeeNumber = "R002",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234503",
                firstName = "Игорь",
                lastName = "Игорев",
                patronymic = "Игоревич",
                position = "рабочий",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Корнеева",
                    home = 42,
                    corpus = null,
                    apartment = 111
                ),
                age = 22,
                division = "Склад",
                employeeNumber = "R003",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234504",
                firstName = "Анна",
                lastName = "Иванова",
                patronymic = "Ивановна",
                position = "швея",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Энтузиастов",
                    home = 28,
                    corpus = null,
                    apartment = 167
                ),
                age = 43,
                division = "Помещение1",
                employeeNumber = "R004",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234505",
                firstName = "Татьяна",
                lastName = "Петрова",
                patronymic = "Петровна",
                position = "фельдшер",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Большая",
                    home = 14,
                    corpus = "Б",
                    apartment = 234
                ),
                age = 39,
                division = "МедКабинет",
                employeeNumber = "R006",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234506",
                firstName = "Олег",
                lastName = "Сидоров",
                patronymic = "Сидорович",
                position = "технолог",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Длинная",
                    home = 77,
                    corpus = null,
                    apartment = 234
                ),
                age = 55,
                division = "Административная3",
                employeeNumber = "R006",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234507",
                firstName = "Мария",
                lastName = "Сидорова",
                patronymic = "Сидоровна",
                position = "технолог",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Маркса",
                    home = 52,
                    corpus = null,
                    apartment = 66
                ),
                age = 53,
                division = "Административная3",
                employeeNumber = "R007",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234508",
                firstName = "Василий",
                lastName = "Васин",
                patronymic = "Васильевич",
                position = "слесарь",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "проспект Ленина",
                    home = 15,
                    corpus = "Д",
                    apartment = 243
                ),
                age = 44,
                division = "Мастерская",
                employeeNumber = "R008",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234509",
                firstName = "Марина",
                lastName = "Васина",
                patronymic = "Васильевна",
                position = "фасовщица",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Короткая",
                    home = 6,
                    corpus = null,
                    apartment = 55
                ),
                age = 44,
                division = "Помещение1",
                employeeNumber = "R009",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234510",
                firstName = "Александр",
                lastName = "Александрин",
                patronymic = "Александрович",
                position = "грузчик",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "проспект Героев",
                    home = 1,
                    corpus = null,
                    apartment = 6
                ),
                age = 36,
                division = "Склад",
                employeeNumber = "R010",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234511",
                firstName = "Дмитрий",
                lastName = "Дмитров",
                patronymic = "Дмитриевич",
                position = "грузчик",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Сормовская",
                    home = 12,
                    corpus = "В",
                    apartment = 76
                ),
                age = 37,
                division = "Склад",
                employeeNumber = "R011",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            ),
            Employee(
                plotNumber = "1234512",
                firstName = "Михаил",
                lastName = "Мишин",
                patronymic = "Михайлович",
                position = "разнорабочий",
                address = Address(
                    country = "Россия",
                    city = "Москва",
                    street = "Арбатская",
                    home = 44,
                    corpus = null,
                    apartment = 14
                ),
                age = 29,
                division = "Склад",
                employeeNumber = "R012",
                phoneNumber = "+7(999)999-99-99",
                photo = null
            )
        )
    }
    override suspend fun getListBrigade(): BrigadeResponse {
        val date = currentDate()
        val dateMs = currentDateMs()

        return BrigadeResponse(
            listOf(
                BrigadeEmployee(
                    plotNumber = "1234501",
                    firstName = "Иван",
                    lastName = "Иванов",
                    patronymic = "Иванович",
                    status = "На смене",
                    position = "слесарь",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234502",
                    firstName = "Петр",
                    lastName = "Петров",
                    patronymic = "Петрович",
                    status = "На смене",
                    position = "водитель",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234503",
                    firstName = "Игорь",
                    lastName = "Игорев",
                    patronymic = "Игоревич",
                    status = "На смене",
                    position = "рабочий",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234504",
                    firstName = "Анна",
                    lastName = "Иванова",
                    patronymic = "Ивановна",
                    status = "На смене",
                    position = "швея",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234505",
                    firstName = "Татьяна",
                    lastName = "Петрова",
                    patronymic = "Петровна",
                    status = "На смене",
                    position = "фельдшер",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234506",
                    firstName = "Олег",
                    lastName = "Сидоров",
                    patronymic = "Сидорович",
                    status = "На смене",
                    position = "технолог",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234507",
                    firstName = "Мария",
                    lastName = "Сидорова",
                    patronymic = "Сидоровна",
                    status = "На смене",
                    position = "технолог",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234508",
                    firstName = "Василий",
                    lastName = "Васин",
                    patronymic = "Васильевич",
                    status = "На смене",
                    position = "слесарь",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234509",
                    firstName = "Марина",
                    lastName = "Васина",
                    patronymic = "Васильевна",
                    status = "На смене",
                    position = "фасовщица",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234510",
                    firstName = "Александр",
                    lastName = "Александрин",
                    patronymic = "Александрович",
                    status = "На смене",
                    position = "грузчик",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234511",
                    firstName = "Дмитрий",
                    lastName = "Дмитров",
                    patronymic = "Дмитриевич",
                    status = "На смене",
                    position = "грузчик",
                    date = date,
                    dateMs = dateMs
                ),
                BrigadeEmployee(
                    plotNumber = "1234512",
                    firstName = "Михаил",
                    lastName = "Мишин",
                    patronymic = "Михайлович",
                    status = "На смене",
                    position = "разнорабочий",
                    date = date,
                    dateMs = dateMs
                ),
            )
        )
    }
}