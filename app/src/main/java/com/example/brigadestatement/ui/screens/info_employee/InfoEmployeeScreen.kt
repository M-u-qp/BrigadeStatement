package com.example.brigadestatement.ui.screens.info_employee

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.brigadestatement.R
import com.example.brigadestatement.domain.model.Employee
import com.example.brigadestatement.ui.Dimens
import com.example.brigadestatement.ui.Dimens.FontSizeLarge3
import com.example.brigadestatement.ui.Dimens.FontSizeMedium4
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall10
import com.example.brigadestatement.ui.Dimens.PaddingMedium6
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.common.NavigateUpBar

@Composable
fun InfoEmployeeScreen(
    employee: Employee?,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = PaddingMedium6)
            .padding(horizontal = Dimens.PaddingMedium4)
    ) {
        val title = stringResource(id = R.string.Profile_employee)
        NavigateUpBar(
            navigateUp = navigateUp,
            text = title
        )
        if (employee != null) {
            Row(
                modifier = Modifier.padding(top = PaddingMedium6)
            ) {
                if (employee.photo != null) {
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium),
                        model = ImageRequest.Builder(context)
                            .data(employee.photo).build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium),
                        painter = painterResource(id = R.drawable.employee_photo_off),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier.padding(start = PaddingSmall6)
                ) {
                    Text(
                        text = "${employee.lastName} ${employee.firstName} ${employee.patronymic}",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black),
                            fontSize = FontSizeLarge3
                        )
                    )
                    Text(
                        modifier = Modifier.padding(top = PaddingExtraSmall10),
                        text = employee.position,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = colorResource(id = R.color.gray),
                            fontSize = FontSizeMedium4
                        )
                    )
                }
            }
        }
    }
}