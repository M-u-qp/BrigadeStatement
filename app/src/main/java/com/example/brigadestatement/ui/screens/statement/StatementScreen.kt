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
import androidx.compose.material3.Button
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
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.common.currentDate

@Composable
fun StatementScreen(
    viewModel: StatementViewModel = hiltViewModel(),
    state: StatementState,
    navigateToFilter: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.getBrigadeEmployees(currentDate())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.PaddingMedium4)
            .padding(horizontal = Dimens.PaddingMedium4)
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

        JustButton(onClick = navigateToFilter, text = stringResource(id = R.string.Search_by_filters))

        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))

        Box {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.PaddingExtraSmall8),
                verticalArrangement = Arrangement.spacedBy(Dimens.PaddingExtraSmall6)
            ) {
                if (state.currentBrigade.isNotEmpty()) {
                    item {
                        Box(modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = "${state.currentBrigade.first()?.date}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = FontSizeLarge5,
                                    color = colorResource(id = R.color.black)
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))
                    }
                    items(state.currentBrigade) { employee ->
                        employee?.let {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
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
                                Text(
                                    text = employee.status,
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
}