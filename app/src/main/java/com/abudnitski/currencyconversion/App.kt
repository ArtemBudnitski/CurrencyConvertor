package com.abudnitski.currencyconversion

import android.app.Application
import android.content.Context
import com.abudnitski.currencyconversion.data.CurrencyRepository
import com.abudnitski.currencyconversion.data.api.ApiService
import com.abudnitski.currencyconversion.data.api.ApiClient
import com.abudnitski.currencyconversion.data.db.AppDatabase
import com.abudnitski.currencyconversion.domain.CurrencyMapper
import com.abudnitski.currencyconversion.presentation.list.ListUiStateMapper

class App : Application() {
    private val apiService: ApiService by lazy {
        ApiClient.retrofit.create(ApiService::class.java)
    }
    private val sharedPref by lazy {
        getSharedPreferences(
            getString(R.string.preferences_file), Context.MODE_PRIVATE
        )
    }
    private val database by lazy { AppDatabase.getDatabase(this, sharedPref) }
    val repository by lazy { CurrencyRepository(database.currencyDao(), apiService, CurrencyMapper(), sharedPref) }
    val listUiStateMapper = ListUiStateMapper()

}
