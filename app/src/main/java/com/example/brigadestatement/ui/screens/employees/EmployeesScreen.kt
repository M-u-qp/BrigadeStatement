package com.example.brigadestatement.ui.screens.employees

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.BorderWidth
import com.example.brigadestatement.ui.Dimens.FontSizeLarge3
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingSmall2
import com.example.brigadestatement.ui.common.Searching

@Composable
fun EmployeesScreen(
    state: EmployeesState,
    navigateToInfoEmployee: (Employee?) -> Unit
) {
    val searchText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = PaddingMedium4)
            .padding(horizontal = PaddingMedium4)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.Employees),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.FontSizeExtraLarge5
            )
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(PaddingExtraSmall8)
        ) {

            item {
                Searching(
                    searchText = searchText,
                    hintText = stringResource(id = R.string.Enter_beginning_last_name)
                )
                Spacer(modifier = Modifier.height(Dimens.PaddingMedium6))
            }
            //Фильтруем список при введеных символах в поисковик
            val filteredEmployees = if (searchText.value.isNotEmpty()) {
                state.employees.filter { employee ->
                    employee?.lastName?.startsWith(
                        prefix = searchText.value,
                        ignoreCase = true
                    ) ?: false
                }
            } else {
                state.employees
            }
            items(filteredEmployees) { employee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigateToInfoEmployee(employee)
                        },
                    shape = MaterialTheme.shapes.small,
                    border = BorderStroke(
                        width = BorderWidth,
                        color = colorResource(id = R.color.black)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                horizontal = PaddingSmall2,
                                vertical = PaddingSmall2
                            ),
                    ) {
                        Text(
                            text = "${employee?.lastName} ${employee?.firstName} ${employee?.patronymic}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.W400,
                                fontSize = FontSizeLarge3,
                                color = colorResource(id = R.color.black)
                            )
                        )
                    }
                }
            }
        }
    }
}