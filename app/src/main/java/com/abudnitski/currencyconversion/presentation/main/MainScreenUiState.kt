package com.abudnitski.currencyconversion.presentation.main

data class MainScreenUiState(
    val firstCurrency: String = "",
    val secondCurrency: String = "",
    val firstRateValue: String = "",
    val secondRateValue: String = "",
    val firstCurrencyValue: String = "",
    val secondCurrencyValue: String = "",
    val onKeyboardClick: (String) -> Unit = {},
    val showDialog: Boolean = false,
    val onDialogClosed: () -> Unit = {},
    val isDataError: Boolean = false,
    val exitButton: () -> Unit = {},
    val tryAgainButton: () -> Unit = {},
    val isDataLoading: Boolean = true
)
