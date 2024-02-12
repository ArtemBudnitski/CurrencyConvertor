package com.abudnitski.currencyconversion.domain

import com.abudnitski.currencyconversion.data.api.CurrencyNet
import com.abudnitski.currencyconversion.data.api.CurrencyTwo
import com.abudnitski.currencyconversion.data.db.CurrencyEntity
import java.math.BigDecimal
import java.math.RoundingMode

class CurrencyMapper {

    fun map(data: CurrencyEntity): Currency {
        return Currency(code = data.code, value = data.value)
    }

    fun mapEntity(data: List<CurrencyEntity>): List<Currency> {
        return data.map { map(it) }
    }

    fun map(data: List<Currency>): List<CurrencyEntity> {
        return data.map { map(it) }
    }

    private fun map(data: Currency): CurrencyEntity {
        return CurrencyEntity(code = data.code, value = data.value)
    }

    fun map(data: CurrencyNet): List<Currency> {
        return data.data.values.map { map(it) }
    }

    private fun map(data: CurrencyTwo): Currency {
        val rounded = (data.value ?: BigDecimal(0)).setScale(8, RoundingMode.HALF_UP)
        return Currency(code = data.code.orEmpty(), value = rounded.toDouble())
    }
}
