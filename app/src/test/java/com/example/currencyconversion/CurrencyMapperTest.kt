package com.example.currencyconversion

import com.abudnitski.currencyconversion.data.api.CurrencyNet
import com.abudnitski.currencyconversion.data.api.CurrencyTwo
import com.abudnitski.currencyconversion.data.api.Meta
import com.abudnitski.currencyconversion.data.db.CurrencyEntity
import com.abudnitski.currencyconversion.domain.Currency
import com.abudnitski.currencyconversion.domain.CurrencyMapper
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.math.BigDecimal

class CurrencyMapperTest {
    private val sut = CurrencyMapper()

    @Test
    fun `map Entity Test`() {
        val data: List<CurrencyEntity> = listOf(CurrencyEntity("EUR", 123.0), CurrencyEntity("EUR", 245.0))
        val result = sut.mapEntity(data)

        val expected: List<Currency> = listOf(Currency("EUR", 123.0), Currency("EUR", 245.0))
        assertEquals(expected, result)
    }

    @Test
    fun `map from List of Currency to List of Currency Entity`() {
        val data: List<Currency> = listOf(Currency("EUR", 123.0), Currency("EUR", 245.0))
        val result = sut.map(data)

        val expected: List<CurrencyEntity> = listOf(CurrencyEntity("EUR", 123.0), CurrencyEntity("EUR", 245.0))
        assertEquals(expected, result)
    }

    @Test
    fun `map from CurrencyNet to List of Currency`() {
        val data = CurrencyNet(
            Meta("123"),
            mapOf("USD" to CurrencyTwo("USD", BigDecimal.valueOf(111)), "EUR" to CurrencyTwo("EUR", BigDecimal.valueOf(222)))
        )
        val result = sut.map(data)

        val expected: List<Currency> = listOf(Currency("USD", 111.0), Currency("EUR", 222.0))
        assertEquals(expected,result)
    }
}
