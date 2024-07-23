package com.example.brigadestatement.ui.screens.statement_filter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingMedium6
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.common.NavigateUpBar
import com.example.brigadestatement.ui.screens.statement_filter.components.DialogDates
import com.example.brigadestatement.ui.screens.statement_filter.components.DialogEmployees
import com.example.brigadestatement.ui.screens.statement_filter.components.DialogStatus
import com.example.brigadestatement.ui.screens.statement_filter.components.FilterElementToSelect
import kotlinx.coroutines.launch

@Composable
fun StatementFilterScreen(
    viewModel: StatementFilterViewModel = hiltViewModel(),
    state: StatementFilterState,
    navigateToStatement: (FilterData?) -> Unit,
    navigateUp: () -> Unit
) {

    val scope = rememberCoroutineScope()

    if (state.showDialogEmployees) {
        DialogEmployees(viewModel = viewModel, state = state)
    }
    if (state.showDialogDates) {
        DialogDates(viewModel = viewModel, state = state)
    }
    if (state.showDialogStatus) {
        DialogStatus(viewModel = viewModel, state = state)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val title = stringResource(id = R.string.Search_parameters)
            NavigateUpBar(
                modifier = Modifier
                    .padding(top = PaddingMedium6)
                    .padding(horizontal = PaddingMedium4),
                navigateUp = navigateUp,
                text = title
            )

            Spacer(modifier = Modifier.height(PaddingMedium6))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingMedium6))

            val selectedEmployees = if (state.selectEmployees.isEmpty()) {
                stringResource(id = R.string.Employees_for_finding)
            } else {
                state.selectEmployees.joinToString (", "){ it }
            }

            FilterElementToSelect(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                nameFilter = stringResource(id = R.string.Selected_employees),
                selectedFilters = selectedEmployees,
                onClick = { viewModel.updateVisibleDialogEmployees(true) }
            )

            Spacer(modifier = Modifier.height(PaddingMedium6))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingMedium6))

            val selectedDates = if (state.dateRange == 0L..0L) {
                stringResource(id = R.string.Dates_for_finding)
            } else {
                state.selectedDates
            }
            FilterElementToSelect(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                nameFilter = stringResource(id = R.string.Selected_dates),
                selectedFilters = selectedDates,
                onClick = { viewModel.updateVisibleDialogDates(true) }
            )

            Spacer(modifier = Modifier.height(PaddingMedium6))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingMedium6))

            val selectedStatus = if (state.selectStatus.isEmpty()){
                stringResource(id = R.string.Status_for_finding)
            } else {
                state.selectStatus.joinToString(", ") { it }
            }
            FilterElementToSelect(
                modifier = Modifier.padding(horizontal = PaddingMedium4),
                nameFilter = stringResource(id = R.string.Selected_status),
                selectedFilters = selectedStatus,
                onClick = { viewModel.updateVisibleDialogStatus(true) }
            )

            Spacer(modifier = Modifier.height(PaddingMedium6))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(PaddingMedium6))

        }
        Column(
            modifier = Modifier
                .padding(horizontal = PaddingMedium4)
                .align(Alignment.BottomCenter)
        ) {
            JustButton(
                onClick = {
                    scope.launch {
                        navigateToStatement(viewModel.updateFilterData())
                    }
                },
                text = stringResource(id = R.string.ApplyFilters)
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))
        }
    }
}