package com.example.brigadestatement.ui.screens.info_employee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens

@Composable
fun InfoCardEmployee(
    modifier: Modifier = Modifier,
    photoUrl: String?,
    name: String,
    position: String
) {
    val context = LocalContext.current

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        if (photoUrl != null) {
            AsyncImage(
                modifier = Modifier
                    .size(Dimens.ImageSmallSize)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context)
                    .data(photoUrl).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .size(Dimens.ImageSmallSize)
                    .clip(MaterialTheme.shapes.medium),
                painter = painterResource(id = R.drawable.employee_photo_off),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.padding(start = Dimens.PaddingSmall6)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeLarge3
                )
            )
            val positionTitle = stringResource(id = R.string.Position)
            Text(
                modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
                text = "$positionTitle:",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = colorResource(id = R.color.gray),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
            Text(
                text = "    $position",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = colorResource(id = R.color.black),
                    fontSize = Dimens.FontSizeMedium4
                )
            )
        }
    }
}