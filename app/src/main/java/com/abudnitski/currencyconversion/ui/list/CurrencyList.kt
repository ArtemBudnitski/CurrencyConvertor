package com.abudnitski.currencyconversion.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abudnitski.currencyconversion.R
import com.abudnitski.currencyconversion.presentation.list.ListViewModel


@Composable
fun ListScreen(modifier: Modifier = Modifier, onClick: (String) -> Unit, onBackClick: () -> Unit) {
    val viewModel = hiltViewModel<ListViewModel>()
    val listUiState = viewModel.uiState.collectAsState().value

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopAppSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            onBackClick = { onBackClick() },
            searchText = listUiState.searchText,
            onSearchTextChange = { viewModel.setSearchText(it) }
        )
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(listUiState.filteredItems) {
                Spacer(modifier = modifier)
                CurrencyItem(onClick = { onClick(it.code) }, listItem = it)
            }
        }
    }
}

@Composable
private fun TopAppSearchBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    searchText: String,
    onSearchTextChange: (String) -> Unit
) {
    Row(
        modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .height(64.dp)
            .padding(top = 4.dp)
    ) {
        IconButton(onClick = { onBackClick() }, modifier.weight(0.3f)) {
            Icon(
                painter = painterResource(id = R.drawable.round_arrow_back_24),
                contentDescription = stringResource(R.string.back),
                tint = Color.White
            )
        }
        TextField(
            value = searchText,
            onValueChange = { onSearchTextChange(it) },
            placeholder = { Text(text = stringResource(R.string.search), fontWeight = FontWeight.Bold) },
            modifier = modifier
                .weight(1f)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        )
        Spacer(modifier = modifier.weight(0.1f))
    }
}
