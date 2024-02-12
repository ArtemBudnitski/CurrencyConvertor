package com.abudnitski.currencyconversion.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abudnitski.currencyconversion.data.CurrencyRepository

class ListViewModelFactory(
    private val repository: CurrencyRepository,
    private val listUiStateMapper: ListUiStateMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListViewModel(repository, listUiStateMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}