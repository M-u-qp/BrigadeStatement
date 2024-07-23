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
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.common.Searching
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterState
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterViewModel

@Composable
fun DialogStatus(
    viewModel: StatementFilterViewModel,
    state: StatementFilterState,
) {
    val searchText = remember { mutableStateOf("") }
    val selectedStatus = remember { mutableStateListOf<String>() }

    Dialog(
        onDismissRequest = {
            state.showDialogEmployees
            viewModel.updateVisibleDialogEmployees(false)
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box {
            Card(
                modifier = Modifier.padding(Dimens.PaddingExtraSmall10),
                shape = MaterialTheme.shapes.medium
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Dimens.PaddingExtraSmall10)
                ) {
                    item {
                        Searching(
                            modifier = Modifier.padding(horizontal = Dimens.PaddingMedium4),
                            searchText = searchText,
                            hintText = stringResource(id = R.string.Enter_beginning_status)
                        )
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium6))

                        if (searchText.value.isEmpty()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = Dimens.PaddingMedium4),
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
                                    checked = selectedStatus.size == state.allStatus.size,
                                    onCheckedChange = { isChecked ->
                                        if (isChecked) {
                                            state.allStatus.forEach { status ->
                                                if (!selectedStatus.contains(status)) {
                                                    selectedStatus.add(status)
                                                }
                                            }
                                        } else {
                                            state.allStatus.forEach { status ->
                                                if (selectedStatus.contains(status)) {
                                                    selectedStatus.remove(status)
                                                }
                                            }
                                        }
                                    }
                                )
                            }
                        }



                        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall8))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall8))
                    }
                    //Фильтруем список при введеных символах в поисковик
                    val filteredStatus = if (searchText.value.isNotEmpty()) {
                        state.allStatus.filter { status ->
                            status.startsWith(
                                prefix = searchText.value,
                                ignoreCase = true
                            )
                        }
                    } else {
                        state.allStatus
                    }
                    items(filteredStatus) { status ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.PaddingMedium4),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = status,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = Dimens.FontSizeLarge3,
                                    fontWeight = FontWeight.Medium,
                                    color = colorResource(id = R.color.black)
                                )
                            )
                            Checkbox(
                                checked = selectedStatus.contains(status),
                                onCheckedChange = { isChecked ->
                                    if (isChecked) {
                                        selectedStatus.add(status)
                                    } else {
                                        selectedStatus.remove(status)
                                    }
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall8))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall8))
                    }

                    item {
                        Spacer(modifier = Modifier.height(Dimens.PaddingLarge10))
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = Dimens.PaddingMedium4)
                    .align(Alignment.BottomCenter)
            ) {
                JustButton(
                    onClick = {
                        viewModel.updateSelectedStatus(selectedStatus = selectedStatus)
                        viewModel.updateVisibleDialogStatus(false)
                    },
                    text = stringResource(id = R.string.ApplyFilters)
                )
                Spacer(modifier = Modifier.height(Dimens.PaddingSmall2))
            }
        }
    }
}