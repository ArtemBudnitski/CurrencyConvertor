package com.abudnitski.currencyconversion.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abudnitski.currencyconversion.data.CurrencyRepository

class MainScreenViewModelFactory(
    private val repository: CurrencyRepository,
    private val currencyField: Int?,
    private val currencyCode: String?
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainScreenViewModel(repository, currencyField, currencyCode, Calculator()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}