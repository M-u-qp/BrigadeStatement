package com.example.brigadestatement.ui.screens.brigade.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.BorderWidth
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.common.getColorOrIcon

@Composable
fun CardEmployee(
    modifier: Modifier = Modifier,
    firstName: String,
    lastName: String,
    status: String,
    position: String
) {

    val containerColor = getColorOrIcon(value = status, id = 0)
    val containerBorderColor = getColorOrIcon(value = status, id = 1)
    val icon = getColorOrIcon(value = status, id = 2)

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = containerColor)
        ),
        border = BorderStroke(
            width = BorderWidth,
            color = colorResource(id = containerBorderColor)
        ),
        shape = ShapeDefaults.Medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PaddingExtraSmall8, vertical = PaddingSmall6),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "$firstName $lastName",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = Dimens.FontSizeLarge3,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.black)
                    )
                )

                Text(
                    text = position,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = Dimens.FontSizeLarge1,
                        color = colorResource(
                            id = R.color.gray
                        )
                    )
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = colorResource(id = containerBorderColor)
                )

                Text(
                    text = status,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = Dimens.FontSizeLarge1,
                        color = colorResource(id = containerBorderColor)
                    )
                )
            }
        }
    }
}