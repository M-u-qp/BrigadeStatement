package com.example.brigadestatement.ui.screens.statement_filter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens

@Composable
fun FilterElementToSelect(
    modifier: Modifier = Modifier,
    nameFilter: String,
    selectedFilters: String,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(0.8f)) {
            Text(
                text = "$nameFilter:",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = Dimens.FontSizeLarge1,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall10))

            Text(
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                text = selectedFilters,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = Dimens.FontSizeMedium4,
                    color = colorResource(id = R.color.gray)
                )
            )
        }

        IconButton(
            modifier = Modifier
                .border(
                    width = Dimens.BorderWidth,
                    color = colorResource(id = R.color.green_border),
                    shape = MaterialTheme.shapes.small
                )
                .background(
                    color = colorResource(id = R.color.green_card),
                    shape = MaterialTheme.shapes.small
                ),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_check_list
                ),
                contentDescription = null
            )
        }
    }
}