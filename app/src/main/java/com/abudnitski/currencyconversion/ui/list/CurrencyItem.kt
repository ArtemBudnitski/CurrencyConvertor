package com.abudnitski.currencyconversion.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abudnitski.currencyconversion.presentation.list.ListItem

@Composable
fun CurrencyItem(modifier: Modifier = Modifier, listItem: ListItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 16.dp, horizontal = 12.dp)
            .clickable { onClick() },

        ) {
        Text(text = listItem.flag, modifier.padding(top = 4.dp))
        Spacer(modifier.weight(0.5f))
        Text(text = listItem.code, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier.weight(10f))

    }
}
