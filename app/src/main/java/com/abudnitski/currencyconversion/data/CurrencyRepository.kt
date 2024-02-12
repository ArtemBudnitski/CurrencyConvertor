package com.abudnitski.currencyconversion.data

import android.content.SharedPreferences
import com.abudnitski.currencyconversion.data.api.ApiService
import com.abudnitski.currencyconversion.data.db.CurrencyDao
import com.abudnitski.currencyconversion.domain.Currency
import com.abudnitski.currencyconversion.domain.CurrencyMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.ZoneOffset

class CurrencyRepository(
    private val currencyDao: CurrencyDao,
    private val apiService: ApiService,
    private val currencyMapper: CurrencyMapper,
    private val sharedPref: SharedPreferences
) {

    var currentCodeOne = "USD"
    var currentCodeTwo = "EUR"
    var currencyOneValue = "100"

    private fun useCache(): Boolean {
        val today = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
        val lastUpdate = sharedPref.getLong(LAST_UPDATE_KEY, 0)
        return lastUpdate == today
    }

    suspend fun getAllCurrency(): Flow<List<Currency>> {
        val today = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
        return if (useCache()) {
            currencyDao.getAll().map {
                currencyMapper.mapEntity(it)
            }
        } else {
            val netModels = apiService.getAllCurrency("", "")
            val domainModels = currencyMapper.map(netModels)
            with(sharedPref.edit()) {
                putLong(LAST_UPDATE_KEY, today)
                apply()
            }
            insert(domainModels)
            flowOf(domainModels)
        }
    }

    @Suppress("RedundantSuspendModifier")
    private suspend fun insert(currencies: List<Currency>) {
        val entityModels = currencyMapper.map(currencies)
        currencyDao.insertAll(*entityModels.toTypedArray())
    }

    @Suppress("RedundantSuspendModifier")
    suspend fun find(code: String): Currency {
        val data = currencyDao.findByCode(code = code)
        return currencyMapper.map(data)
    }

    companion object {
        const val LAST_UPDATE_KEY = "LAST_UPDATE_KEY"
    }
}
