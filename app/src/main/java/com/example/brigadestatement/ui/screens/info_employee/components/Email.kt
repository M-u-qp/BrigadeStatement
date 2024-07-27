package com.example.brigadestatement.ui.screens.info_employee.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens

@Composable
fun Email(
    modifier: Modifier = Modifier,
    email: String
) {
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation("email", email)
        withStyle(
            SpanStyle(
            color = Color.Blue,
            fontSize = Dimens.FontSizeLarge3,
            fontWeight = FontWeight.W400,
        )
        ) {
            append(email)
        }
        pop()
    }

    val emailTitle = stringResource(id = R.string.Email)
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(top = Dimens.PaddingExtraSmall10),
            text = "$emailTitle:",
            style = MaterialTheme.typography.bodySmall.copy(
                color = colorResource(id = R.color.gray),
                fontSize = Dimens.FontSizeMedium4
            )
        )
        Text(
            modifier = Modifier.clickable {
                Intent(Intent.ACTION_SENDTO).also {
                    it.data = Uri.parse("mailto:$email")
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            text = "    $annotatedString",
            color = Color.Blue
        )
    }
}