package com.example.brigadestatement.ui.screens.brigade.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.window.Dialog
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens.BorderWidth
import com.example.brigadestatement.ui.Dimens.FontSizeLarge3
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.common.StatusGreen
import com.example.brigadestatement.ui.common.StatusRed
import com.example.brigadestatement.ui.screens.brigade.BrigadeViewModel

@Composable
fun DialogStatus(
    viewModel: BrigadeViewModel,
    goodOrBadStatus: Boolean
) {
    var dismiss by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Dialog(
        onDismissRequest = {
            dismiss = false
            viewModel.updateVisibleDialogStatus(show = false)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingMedium4)
                .verticalScroll(state = scrollState)
                .alpha(0.9f)
        ) {
            if (goodOrBadStatus) {
                StatusGreen.entries.forEach {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = PaddingSmall6)
                            .clickable {
                                viewModel.updateStatusEmployee(status = it.value)
                                viewModel.updateVisibleDialogStatus(show = false)
                            }
                            .background(
                                shape = MaterialTheme.shapes.medium,
                                color = colorResource(id = R.color.green_card)
                            )
                            .border(
                                width = BorderWidth,
                                color = colorResource(id = R.color.green_border),
                                shape = MaterialTheme.shapes.medium
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = PaddingSmall6),
                            text = it.value,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = FontSizeLarge3,
                                color = colorResource(id = R.color.black)
                            )
                        )
                    }
                }
            } else {
                StatusRed.entries.forEach {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = PaddingSmall6)
                            .clickable {
                                viewModel.updateStatusEmployee(status = it.value)
                                viewModel.updateVisibleDialogStatus(show = false)
                            }
                            .background(
                                shape = MaterialTheme.shapes.medium,
                                color = colorResource(id = R.color.red_card)
                            )
                            .border(
                                width = BorderWidth,
                                color = colorResource(id = R.color.red_border),
                                shape = MaterialTheme.shapes.medium
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = PaddingSmall6),
                            text = it.value,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = FontSizeLarge3,
                                color = colorResource(id = R.color.black)
                            )
                        )
                    }
                }
            }
        }
    }
}