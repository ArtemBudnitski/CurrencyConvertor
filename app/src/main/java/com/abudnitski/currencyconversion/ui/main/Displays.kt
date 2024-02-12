package com.abudnitski.currencyconversion.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abudnitski.currencyconversion.presentation.main.MainScreenUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Displays(
    modifier: Modifier = Modifier,
    mainScreenUiState: MainScreenUiState,
    onClickScreenOne: (String) -> Unit,
    onClickScreenTwo: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        OutlinedCard(
            modifier = Modifier
                .padding(top = 30.dp, start = 21.dp, end = 21.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 75f, topEnd = 75f, bottomStart = 1f, bottomEnd = 1f),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
            onClick = { onClickScreenOne(mainScreenUiState.firstCurrency) }


        ) {
            Column(
                modifier = modifier
                    .padding(
                        top = 21.dp,
                        bottom = 21.dp,
                        start = 12.dp,
                        end = 12.dp
                    )
            ) {
                Row(modifier = Modifier.padding(end = 4.dp)) {
                    Text(text = mainScreenUiState.firstCurrency, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Spacer(modifier = modifier.weight(1f))
                    Text(text = mainScreenUiState.firstCurrencyValue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                if (!mainScreenUiState.isDataError) {
                    Text(
                        text = "1" + mainScreenUiState.firstCurrency + " = " + mainScreenUiState.secondRateValue + mainScreenUiState.secondCurrency,
                        fontSize = 14.sp
                    )
                }

            }
        }
        ElevatedCard(
            modifier = Modifier
                .padding(bottom = 30.dp, start = 21.dp, end = 21.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 1f, topEnd = 1f, bottomStart = 75f, bottomEnd = 75f),
            onClick = { onClickScreenTwo(mainScreenUiState.secondCurrency) }


        ) {
            Column(
                modifier = modifier
                    .padding(
                        top = 21.dp,
                        bottom = 21.dp,
                        start = 12.dp,
                        end = 12.dp
                    )
            ) {
                Row(modifier = Modifier.padding(end = 4.dp)) {
                    Text(text = mainScreenUiState.secondCurrency, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Spacer(modifier = modifier.weight(1f))
                    Text(text = mainScreenUiState.secondCurrencyValue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}