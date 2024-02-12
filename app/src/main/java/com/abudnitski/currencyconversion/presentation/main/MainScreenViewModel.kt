package com.abudnitski.currencyconversion.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abudnitski.currencyconversion.data.CurrencyRepository
import com.abudnitski.currencyconversion.domain.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class MainScreenViewModel(
    private val repository: CurrencyRepository,
    private val currencyField: Int?,
    private val currencyCode: String?,
    private val calculator: Calculator
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadData()
        }
    }

    private suspend fun init() {
        if (currencyCode != null) {
            if (currencyField == 1) {
                repository.currentCodeOne = currencyCode
            } else {
                repository.currentCodeTwo = currencyCode
            }
        }
        val firstCurrency = repository.find(repository.currentCodeOne)
        val secondCurrency = repository.find(repository.currentCodeTwo)
        val firstValue = repository.currencyOneValue

        val state = invalidateUiState(firstCurrency, secondCurrency, firstValue)
        _uiState.value = state
    }

    private fun invalidateUiState(currencyOne: Currency, currencyTwo: Currency, firstValue: String): MainScreenUiState {
        val secondRateCurrency = calculator.calculateRate(
            currencyOne.value.toString(),
            currencyTwo.value.toString(),
        )

        val secondCurrencyValue = secondRateCurrency.toDouble() * firstValue.toDouble()

        return MainScreenUiState(
            firstCurrency = currencyOne.code,
            secondCurrency = currencyTwo.code,
            firstRateValue = "%.2f".format(Locale.US, 1.0),
            secondRateValue = "%.8f".format(Locale.US, secondRateCurrency.toDouble()),
            firstCurrencyValue = firstValue,
            secondCurrencyValue = "%.2f".format(Locale.US, secondCurrencyValue),
            onKeyboardClick = { onKeyboardClicked(it) }
        )
    }

    private fun loadData() {
        _uiState.value = _uiState.value.copy(isDataLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.getAllCurrency().collect {
                    init()
                    _uiState.value = _uiState.value.copy(isDataLoading = false)
                }
            } catch (e: Exception) {
                _uiState.value =
                    _uiState.value.copy(
                        isDataError = true,
                        isDataLoading = false,
                        tryAgainButton = { onTryAgain() })
            }
        }
    }

    private fun onTryAgain() {
        loadData()
    }

    private fun onKeyboardClicked(key: String) {
        val data = calculator.onKeyboardClicked(
            key,
            repository.currencyOneValue,
            uiState.value.firstRateValue,
            uiState.value.secondRateValue
        )
        if (data == null) {
            _uiState.value = _uiState.value.copy(showDialog = true, onDialogClosed = {
                _uiState.value = _uiState.value.copy(showDialog = false)
            })
        } else {
            repository.currencyOneValue = data.first
            _uiState.value = _uiState.value.copy(
                firstCurrencyValue = data.first,
                secondCurrencyValue = data.second
            )
        }
    }
}