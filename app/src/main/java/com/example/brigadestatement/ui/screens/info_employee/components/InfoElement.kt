package com.example.brigadestatement.ui.screens.info_employee.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens

@Composable
fun InfoElement(
    modifier: Modifier = Modifier,
    titleText: String,
    infoText: String
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
            text = titleText,
            style = MaterialTheme.typography.bodySmall.copy(
                color = colorResource(id = R.color.gray),
                fontSize = Dimens.FontSizeMedium4
            )
        )
        Text(
            text = "    $infoText",
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.W400,
                color = colorResource(id = R.color.black),
                fontSize = Dimens.FontSizeLarge3
            )
        )
    }
}