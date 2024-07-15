package com.example.brigadestatement.ui.screens.brigade.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.example.brigadestatement.ui.Dimens

@Composable
fun ButtonDialogStatus(
    onClick: () -> Unit,
    cardColor: Color,
    borderColor: Color,
    icon: Painter
) {
    Card(
        modifier = Modifier
            .size(Dimens.IconLargeSize)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        border = BorderStroke(
            width = Dimens.BorderWidth,
            color = borderColor
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}