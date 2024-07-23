package com.example.brigadestatement.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens.BorderWidth
import com.example.brigadestatement.ui.Dimens.FontSizeMedium4
import com.example.brigadestatement.ui.Dimens.IconNormalSize

@Composable
fun Searching(
    modifier: Modifier = Modifier,
    searchText: MutableState<String>,
    hintText: String
) {

    val searchTextState by remember { mutableStateOf(searchText) }
    val containerColor = colorResource(id = R.color.gray_light)
    val anotherContainerColor = Color.Transparent
    val themeContainerColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .searchBarBorder(),
        value = searchTextState.value,
        onValueChange = { searchTextState.value = it },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(IconNormalSize),
                tint = colorResource(id = R.color.gray)
            )
        },
        placeholder = {
            Text(
                text = hintText,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = FontSizeMedium4
                ),
                color = colorResource(id = R.color.gray)
            )
        },
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = themeContainerColor,
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            cursorColor = themeContainerColor,
            focusedIndicatorColor = anotherContainerColor,
            unfocusedIndicatorColor = anotherContainerColor,
            disabledIndicatorColor = anotherContainerColor,
            errorIndicatorColor = anotherContainerColor,
        ),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodySmall,
        )
}

private fun Modifier.searchBarBorder() = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = BorderWidth,
            color = Color.Black,
            shape = MaterialTheme.shapes.small
        )
    } else {
        this
    }
}