package com.example.brigadestatement.ui.screens.info_employee

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.brigadestatement.R
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingMedium6
import com.example.brigadestatement.ui.Dimens.PaddingSmall2
import com.example.brigadestatement.ui.common.NavigateUpBar
import com.example.brigadestatement.ui.screens.info_employee.components.CardAddress
import com.example.brigadestatement.ui.screens.info_employee.components.Email
import com.example.brigadestatement.ui.screens.info_employee.components.InfoCardEmployee
import com.example.brigadestatement.ui.screens.info_employee.components.InfoElement
import com.example.brigadestatement.ui.screens.info_employee.components.PhoneNumber

@Composable
fun InfoEmployeeScreen(
    employee: Employee?,
    navigateUp: () -> Unit
) {
    val scrollScale = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = PaddingMedium6)
            .verticalScroll(state = scrollScale)
    ) {
        val title = stringResource(id = R.string.Profile_employee)
        NavigateUpBar(
            navigateUp = navigateUp,
            text = title
        )
        Spacer(modifier = Modifier.height(PaddingMedium6))
        employee?.let {
            InfoCardEmployee(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                photoUrl = employee.photo,
                name = "${employee.lastName} ${employee.firstName} ${employee.patronymic ?: ""}",
                position = employee.position
            )

            Spacer(modifier = Modifier.height(PaddingMedium6))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            PhoneNumber(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                phoneNumber = employee.phoneNumber ?: ""
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            Email(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                email = employee.email ?: ""
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            val ageTitle = stringResource(id = R.string.Age)
            InfoElement(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                titleText = "$ageTitle:",
                infoText = (employee.age ?: 0).toString()
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            employee.address?.let { address ->
                CardAddress(
                    modifier = Modifier.padding(horizontal = PaddingMedium4),
                    country = address.country,
                    city = address.city,
                    street = address.street,
                    home = address.home,
                    corpus = address.corpus,
                    apartment = address.apartment
                )
            }

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            val numberEmployeeTitle = stringResource(id = R.string.Employee_number)
            InfoElement(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                titleText = "$numberEmployeeTitle:",
                infoText = employee.employeeNumber ?: ""
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            val divisionTitle = stringResource(id = R.string.Division)
            InfoElement(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                titleText = "$divisionTitle:",
                infoText = employee.division ?: ""
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))

            val plotNumberTitle = stringResource(id = R.string.Plot_number)
            InfoElement(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                titleText = "$plotNumberTitle:",
                infoText = employee.plotNumber ?: ""
            )

            Spacer(modifier = Modifier.height(PaddingSmall2))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingSmall2))
        }
    }
}