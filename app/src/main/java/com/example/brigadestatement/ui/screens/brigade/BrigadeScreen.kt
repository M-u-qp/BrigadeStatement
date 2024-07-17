package com.example.brigadestatement.ui.screens.brigade

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens.FontSizeExtraLarge5
import com.example.brigadestatement.ui.Dimens.FontSizeMedium4
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall6
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingMedium10
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.common.currentDate
import com.example.brigadestatement.ui.screens.brigade.components.ButtonDialogStatus
import com.example.brigadestatement.ui.screens.brigade.components.CardEmployee
import com.example.brigadestatement.ui.screens.brigade.components.DialogStatus
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun BrigadeScreen(
    viewModel: BrigadeViewModel = hiltViewModel(),
    state: BrigadeState
) {
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.getBrigadeEmployees(currentDate())
    }

    if (state.showDialogStatus) {
        DialogStatus(
            viewModel = viewModel,
            goodOrBadStatus = state.goodOrBadStatus
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = PaddingMedium4)
            .padding(horizontal = PaddingMedium4)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.My_brigade),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = FontSizeExtraLarge5
            )
        )

        Spacer(modifier = Modifier.height(PaddingSmall6))

        Box {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(PaddingExtraSmall6)
            ) {
                itemsIndexed(
                    state.currentBrigade.ifEmpty { state.listBrigade }
                ) { index, employee ->
                    Box {
                        var offsetX by remember { mutableFloatStateOf(0f) }
                        //Кнопка вызова диалога со статусами сотрудника
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = PaddingExtraSmall8),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ButtonDialogStatus(
                                onClick = {
                                    offsetX = 0f
                                    viewModel.updateCurrentIndex(index)
                                    viewModel.updateChoiceGoodOrBadStatus(choice = true)
                                    viewModel.updateVisibleDialogStatus(show = true)
                                },
                                cardColor = colorResource(id = R.color.green_card),
                                borderColor = colorResource(id = R.color.green_border),
                                icon = painterResource(id = R.drawable.ic_good_status)
                            )
                            Spacer(modifier = Modifier.width(PaddingExtraSmall6))
                            ButtonDialogStatus(
                                onClick = {
                                    offsetX = 0f
                                    viewModel.updateCurrentIndex(index)
                                    viewModel.updateChoiceGoodOrBadStatus(choice = false)
                                    viewModel.updateVisibleDialogStatus(show = true)
                                },
                                cardColor = colorResource(id = R.color.red_card),
                                borderColor = colorResource(id = R.color.red_border),
                                icon = painterResource(id = R.drawable.ic_bad_status)
                            )
                        }

                        //Сдвиг на середину экрана карточки сотрудника

                        val screenWidth = LocalConfiguration.current.screenWidthDp
                        val targetOffsetX = (screenWidth / 2) * density.density
                        Box(
                            modifier = Modifier
                                .offset { IntOffset(offsetX.roundToInt(), 0) }
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        offsetX += delta
                                    },
                                    onDragStopped = {
                                        if (offsetX > 0) {
                                            offsetX = 0f
                                        } else if (offsetX < -1) {
                                            offsetX = -targetOffsetX
                                        }
                                    }
                                )
                        ) {
                            //Карточка сотрудника
                            CardEmployee(
                                firstName = employee.firstName,
                                lastName = employee.lastName,
                                status = employee.status,
                                position = employee.position
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(PaddingMedium10))
                }
            }

            Button(
                modifier = Modifier.align(Alignment.BottomCenter),
                enabled = state.currentBrigade.isEmpty() || state.changedStatusEmployee,
                onClick = {
                    scope.launch {
                        viewModel.sendStatement()
                    }
                },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = stringResource(id = R.string.Send_statement),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = FontSizeMedium4,
                        color = colorResource(id = R.color.white)
                    )
                )
            }
        }
    }
}
