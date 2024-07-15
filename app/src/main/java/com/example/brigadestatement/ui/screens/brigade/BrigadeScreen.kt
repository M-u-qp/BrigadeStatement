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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
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
import com.example.brigadestatement.R
import com.example.brigadestatement.ui.Dimens.FontSizeExtraLarge5
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall6
import com.example.brigadestatement.ui.Dimens.PaddingExtraSmall8
import com.example.brigadestatement.ui.Dimens.PaddingMedium4
import com.example.brigadestatement.ui.Dimens.PaddingSmall6
import com.example.brigadestatement.ui.screens.brigade.components.ButtonDialogStatus
import com.example.brigadestatement.ui.screens.brigade.components.CardEmployee
import kotlin.math.roundToInt

@Composable
fun BrigadeScreen(
    state: BrigadeState
) {
    val density = LocalDensity.current

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

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(PaddingExtraSmall6)
        ) {
            items(state.listBrigade) { employee ->
                Box {

                    //Кнопка вызова диалога со статусами сотрудника
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = PaddingExtraSmall8),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ButtonDialogStatus(
                            onClick = {  },
                            cardColor = colorResource(id = R.color.green_card),
                            borderColor = colorResource(id = R.color.green_border),
                            icon = painterResource(id = R.drawable.ic_good_status)
                        )
                        Spacer(modifier = Modifier.width(PaddingExtraSmall6))
                        ButtonDialogStatus(
                            onClick = {  },
                            cardColor = colorResource(id = R.color.red_card),
                            borderColor = colorResource(id = R.color.red_border),
                            icon = painterResource(id = R.drawable.ic_bad_status)
                        )
                    }

                    //Сдвиг на середину экрана карточки сотрудника
                    var offsetX by remember { mutableFloatStateOf(0f) }
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
        }
    }
}
