package com.abudnitski.currencyconversion.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abudnitski.currencyconversion.R
import com.abudnitski.currencyconversion.presentation.main.KeyboardKeys
import com.abudnitski.currencyconversion.presentation.main.MainScreenUiState

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    mainScreenUiState: MainScreenUiState
) {
    Column(
        modifier = modifier.padding(21.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            FilledTonalButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.AC) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_c),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            FilledTonalButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.PERCENT) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_percentage),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            FilledTonalButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.DELETE) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(R.string.delete))
            }
            Button(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.DIV) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_division),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.SEVEN) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_7),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.EIGHT) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_8),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.NINE) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_9),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            Button(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.MUL) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_multiplication),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.FOUR) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_4),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.FIVE) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_5),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.SIX) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            Button(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.SUB) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_minus),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    modifier = modifier.wrapContentSize()
                )

            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.ONE) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(id = R.string.keyboard_1),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.TWO) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_2),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.THREE) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_3),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            Button(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.SUM) }, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp), shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_plus),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.ZERO) }, modifier = modifier
                    .padding(horizontal = 8.dp)
                    .size(75.dp)
                    .weight(2f), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_0),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            ElevatedButton(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.DOT) }, modifier = modifier
                    .padding(horizontal = 8.dp)
                    .size(75.dp)
                    .weight(1f), shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.keyboard_comma),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
            Button(
                onClick = { mainScreenUiState.onKeyboardClick(KeyboardKeys.EQUAL) },
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .size(75.dp),
                shape = RoundedCornerShape(20),
            ) {
                Text(
                    text = stringResource(id = R.string.keyboard_equal),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.wrapContentSize()
                )
            }
        }
    }
}