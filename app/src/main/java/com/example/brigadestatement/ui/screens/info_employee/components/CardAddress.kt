package com.example.brigadestatement.ui.screens.info_employee.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens

@Composable
fun CardAddress(
    modifier: Modifier = Modifier,
    country: String,
    city: String,
    street: String,
    home: Int,
    corpus: String?,
    apartment: Int?
) {

    Column(modifier = modifier.fillMaxWidth()) {

        val addressTitle = stringResource(id = R.string.Address)
        Text(
            modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
            text = "$addressTitle:",
            style = MaterialTheme.typography.bodySmall.copy(
                color = colorResource(id = R.color.gray),
                fontSize = Dimens.FontSizeMedium4
            )
        )
        Column(modifier = Modifier.padding(start = Dimens.PaddingSmall2)) {
            val countryTitle = stringResource(id = R.string.Country)
            Text(
                modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                text = "$countryTitle:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(id = R.color.gray),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
            Text(
                text = "    $country",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeLarge3
                )
            )

            val cityTitle = stringResource(id = R.string.City)
            Text(
                modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                text = "$cityTitle:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(id = R.color.gray),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
            Text(
                text = "    $city",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeLarge3
                )
            )

            val streetTitle = stringResource(id = R.string.Street)
            Text(
                modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                text = "$streetTitle:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(id = R.color.gray),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
            Text(
                text = "    $street",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeLarge3
                )
            )

            val homeTitle = stringResource(id = R.string.Home)
            Text(
                modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                text = "$homeTitle:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(id = R.color.gray),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
            Text(
                text = "    $home",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeLarge3
                )
            )
            if (corpus != null) {
                val corpusTitle = stringResource(id = R.string.Corpus)
                Text(
                    modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                    text = "$corpusTitle:",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = colorResource(id = R.color.gray),
                        fontSize = Dimens.FontSizeMedium4
                    )
                )
                Text(
                    text = "    $corpus",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = colorResource(id = R.color.black),
                        fontSize = Dimens.FontSizeLarge3
                    )
                )
            }

            if (apartment != null) {
                val apartmentTitle = stringResource(id = R.string.Apartment)
                Text(
                    modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                    text = "$apartmentTitle:",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = colorResource(id = R.color.gray),
                        fontSize = Dimens.FontSizeMedium4
                    )
                )
                Text(
                    text = "    $apartment",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = colorResource(id = R.color.black),
                        fontSize = Dimens.FontSizeLarge3
                    )
                )
            }
        }
    }
}