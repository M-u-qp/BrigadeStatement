package com.example.brigadestatement.ui.screens.brigade.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.BorderWidth
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.common.StatusGreen
import com.example.brigadestatement.ui.common.StatusRed

@Composable
fun CardEmployee(
    modifier: Modifier = Modifier,
    firstName: String,
    lastName: String,
    status: String,
    position: String
) {
    val containerColor = when(status) {
        in StatusGreen.entries.map { it.value }.toString() -> colorResource(id = R.color.green_card)
        in StatusRed.entries.map { it.value }.toString() -> colorResource(id = R.color.red_card)
        else -> colorResource(id = R.color.gray_card)
    }

    val containerBorderColor = when(status) {
        in StatusGreen.entries.map { it.value }.toString() -> colorResource(id = R.color.green_border)
        in StatusRed.entries.map { it.value }.toString() -> colorResource(id = R.color.red_border)
        else -> colorResource(id = R.color.gray_border)
    }
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        border = BorderStroke(width = BorderWidth, color = containerBorderColor),
        shape = ShapeDefaults.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PaddingExtraSmall8, vertical = PaddingSmall6),
        ) {
            Text(
                text = "$firstName $lastName",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = Dimens.FontSizeLarge3,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black)
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = position,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = Dimens.FontSizeLarge1,
                        color = colorResource(
                            id = R.color.gray
                        )
                    )
                )

                Text(
                    text = status,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = Dimens.FontSizeLarge1,
                        color = containerBorderColor
                    )
                )
            }

        }
    }
}