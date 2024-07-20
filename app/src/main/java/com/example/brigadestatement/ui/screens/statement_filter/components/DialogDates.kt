package com.example.brigadestatement.ui.screens.statement_filter.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterState
import com.example.brigadestatement.ui.screens.statement_filter.StatementFilterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDates(
    viewModel: StatementFilterViewModel,
    state: StatementFilterState,
) {

    val datePickerStateStart = rememberDatePickerState()
    val datePickerStateEnd = rememberDatePickerState()

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
                LazyColumn {
                    item {
                        DatePicker(
                            state = datePickerStateStart,
                            showModeToggle = false,
                            title = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = PaddingMedium4),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.Select_date_from),
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = FontWeight.Medium,
                                            fontSize = Dimens.FontSizeLarge1,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                }
                            }
                        )

                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall8))
                        HorizontalDivider()

                        DatePicker(
                            state = datePickerStateEnd,
                            showModeToggle = false,
                            title = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = PaddingMedium4),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.Select_date_to),
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = FontWeight.Medium,
                                            fontSize = Dimens.FontSizeLarge1,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                }
                            }
                        )
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
                        viewModel.updateSelectedDates(
                            datePickerStateStart.selectedDateMillis,
                            datePickerStateEnd.selectedDateMillis
                        )
                        viewModel.updateVisibleDialogDates(false)
                    },
                    text = stringResource(id = R.string.ApplyFilters)
                )
                Spacer(modifier = Modifier.height(Dimens.PaddingSmall2))
            }
        }
    }
}