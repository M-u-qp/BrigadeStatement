package com.example.brigadestatement.ui.screens.statement_filter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.brigadestatement.R
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall10
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingLarge10
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingMedium6
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.common.Searching
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterState
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterViewModel

@Composable
fun DialogEmployees(
    viewModel: StatementFilterViewModel,
    state: StatementFilterState,
) {

    val searchText = remember { mutableStateOf("") }
    val selectedEmployees = remember { mutableStateListOf<Employee>() }

    Dialog(
        onDismissRequest = {
            state.showDialogEmployees
            viewModel.updateVisibleDialogEmployees(false)
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box {
            Card(
                modifier = Modifier.padding(horizontal = PaddingExtraSmall10),
                shape = MaterialTheme.shapes.medium
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = PaddingExtraSmall10),
                    verticalArrangement = Arrangement.spacedBy(Dimens.PaddingExtraSmall6)
                ) {
                    item {
                        Searching(
                            modifier = Modifier.padding(horizontal = PaddingMedium4),
                            searchText = searchText
                        )
                        Spacer(modifier = Modifier.height(PaddingMedium6))

                        if (searchText.value.isEmpty()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = PaddingMedium4),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = stringResource(id = R.string.Select_all),
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontSize = Dimens.FontSizeLarge3,
                                        fontWeight = FontWeight.Medium,
                                        color = colorResource(id = R.color.black)
                                    )
                                )
                                Checkbox(
                                    checked = selectedEmployees.size == state.allEmployees.size,
                                    onCheckedChange = { isChecked ->
                                        if (isChecked) {
                                            state.allEmployees.forEach { employee ->
                                                if (!selectedEmployees.contains(employee)) {
                                                    selectedEmployees.add(employee)
                                                }
                                            }
                                        } else {
                                            state.allEmployees.forEach { employee ->
                                                if (selectedEmployees.contains(employee)) {
                                                    selectedEmployees.remove(employee)
                                                }
                                            }
                                        }
                                    }
                                )
                            }
                        }



                        Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                    }

                    //Фильтруем список при введеных символах в поисковик
                    val filteredEmployees = if (searchText.value.isNotEmpty()) {
                        state.allEmployees.filter { employee ->
                            employee.lastName.startsWith(
                                prefix = searchText.value,
                                ignoreCase = true
                            )
                        }
                    } else {
                        state.allEmployees
                    }
                    items(filteredEmployees) { employee ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = PaddingMedium4),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${employee.firstName} ${employee.lastName}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = Dimens.FontSizeLarge3,
                                    fontWeight = FontWeight.Medium,
                                    color = colorResource(id = R.color.black)
                                )
                            )
                            Checkbox(
                                checked = selectedEmployees.contains(employee),
                                onCheckedChange = { isChecked ->
                                    if (isChecked) {
                                        selectedEmployees.add(employee)
                                    } else {
                                        selectedEmployees.remove(employee)
                                    }
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                    }

                    item {
                        Spacer(modifier = Modifier.height(PaddingLarge10))
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = PaddingMedium4)
                    .align(Alignment.BottomCenter)
            ) {
                JustButton(
                    onClick = {
                        viewModel.updateDataSelectedEmployees(selectedEmployees.toList())
                        viewModel.updateVisibleDialogEmployees(false)
                    },
                    text = stringResource(id = R.string.ApplyFilters)
                )
                Spacer(modifier = Modifier.height(PaddingExtraSmall8))
            }
        }
    }
}
