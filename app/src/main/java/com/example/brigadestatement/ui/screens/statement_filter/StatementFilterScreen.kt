package com.example.brigadestatement.ui.screens.statement_filter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.FontSizeLarge1
import com.example.brigadestatement.ui.Dimens.FontSizeMedium4
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.common.JustButton
import com.example.brigadestatement.ui.common.NavigateUpBar

@Composable
fun StatementFilterScreen(
    navigateToStatement: () -> Unit,
    navigateUp: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingMedium4)
        ) {
            val title = stringResource(id = R.string.Search_parameters)
            NavigateUpBar(navigateUp = navigateUp, text = title)

            Spacer(modifier = Modifier.height(Dimens.PaddingMedium6))

            val nameSelectedEmployees = stringResource(id = R.string.Selected_employees)
            Text(
                text = "$nameSelectedEmployees:",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = FontSizeLarge1,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall10))

            Text(
                text = stringResource(id = R.string.Employees_for_finding),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = FontSizeMedium4,
                    color = colorResource(id = R.color.gray)
                )
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingSmall10))
            val nameSelectedDates = stringResource(id = R.string.Selected_dates)
            Text(
                text = "$nameSelectedDates:",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = FontSizeLarge1,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall10))

            Text(
                text = stringResource(id = R.string.Dates_for_finding),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = FontSizeMedium4,
                    color = colorResource(id = R.color.gray)
                )
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingSmall10))

            val nameSelectedStatus = stringResource(id = R.string.Selected_status)
            Text(
                text = "$nameSelectedStatus:",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = FontSizeLarge1,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall10))
            Text(
                text = stringResource(id = R.string.Status_for_finding),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = FontSizeMedium4,
                    color = colorResource(id = R.color.gray)
                )
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingMedium6))

        }
        Column(
            modifier = Modifier
                .padding(horizontal = PaddingMedium4)
                .align(Alignment.BottomCenter)
        ) {
            JustButton(
                onClick = {

                    navigateToStatement()
                },
                text = stringResource(id = R.string.ApplyFilters)
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingSmall6))
        }
    }
}