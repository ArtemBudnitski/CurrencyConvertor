package com.abudnitski.currencyconversion.presentation.list


data class ListUiState(
    val items: List<ListItem>,
    val filteredItems: List<ListItem>,
    val searchText: String,
    val onSearch: (String) -> Unit
)

data class ListItem(
    val code: String = "",
    val flag: String = ""
)
