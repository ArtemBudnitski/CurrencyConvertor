package com.abudnitski.currencyconversion.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abudnitski.currencyconversion.data.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: CurrencyRepository,
    private val listUiStateMapper: ListUiStateMapper
) : ViewModel() {
    private val _uiState = MutableStateFlow(ListUiState(items = emptyList(), searchText = "", onSearch=::setSearchText, filteredItems = emptyList() ))
    val uiState: StateFlow<ListUiState> = _uiState

    init {
        initUiState()
    }

    private fun initUiState() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCurrency().collect {
                val data = listUiStateMapper.map(it)
                _uiState.value = _uiState.value.copy(items = data)
                _uiState.value = _uiState.value.copy(filteredItems = data)
            }
        }
    }

    fun setSearchText(text: String) {
        _uiState.value = _uiState.value.copy(searchText = text, filteredItems = uiState.value.items.filter { it.code.contains(_uiState.value.searchText, true) })
    }
}
