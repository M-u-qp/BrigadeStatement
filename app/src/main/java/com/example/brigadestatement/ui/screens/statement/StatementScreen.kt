package com.example.brigadestatement.ui.screens.statement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.FontSizeLarge5
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingLarge10
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.screens.statement_filter.FilterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun StatementScreen(
    viewModel: StatementViewModel = hiltViewModel(),
    state: StatementState,
    navigateToFilter: () -> Unit,
    filterData: FilterData?
) {

    LaunchedEffect(key1 = true) {
        withContext(Dispatchers.IO) {
            viewModel.getAllBrigadeEmployees()
        }
    }

    LaunchedEffect(state.allBrigades) {
        if (state.allBrigades.isNotEmpty()) {
            viewModel.getFilteredBrigades(filterData = filterData)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.PaddingMedium4)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.Statement),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.FontSizeExtraLarge5
            )
        )

        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))

        JustButton(
            modifier = Modifier.padding(horizontal = Dimens.PaddingMedium4),
            onClick = navigateToFilter,
            text = stringResource(id = R.string.Search_by_filters)
        )

        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))

        Box {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(Dimens.PaddingExtraSmall6)
            ) {
                if (state.filteredBrigades.isNotEmpty()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = "${state.filteredBrigades.first()?.date}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = FontSizeLarge5,
                                    color = colorResource(id = R.color.black)
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))
                    }
                    items(state.filteredBrigades) { employee ->
                        employee?.let {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = Dimens.PaddingMedium4),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(modifier = Modifier.weight(0.7f)) {
                                    Text(
                                        text = "${employee.firstName} ${employee.lastName}",
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontSize = Dimens.FontSizeLarge3,
                                            fontWeight = FontWeight.Medium,
                                            color = colorResource(id = R.color.black)
                                        )
                                    )
                                }

                                Row(modifier = Modifier.weight(0.3f)) {
                                    Text(
                                        text = employee.status,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontSize = Dimens.FontSizeLarge1
                                        )
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                            HorizontalDivider()
                            Spacer(modifier = Modifier.height(PaddingExtraSmall8))
                        }
                    }
                } else {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize().padding(top = PaddingLarge10),
                            contentAlignment = Alignment.Center
                        ) {
                            val notFound = stringResource(id = R.string.Nothing_was_found)
                            val dateMustBe = stringResource(id = R.string.Date_must_be_selected)
                            Text(
                                text = "$notFound \n($dateMustBe)",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = Dimens.FontSizeLarge1
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}