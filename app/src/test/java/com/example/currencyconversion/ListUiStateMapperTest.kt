package com.example.currencyconversion

import com.abudnitski.currencyconversion.domain.Currency
import com.abudnitski.currencyconversion.presentation.list.ListItem
import com.abudnitski.currencyconversion.presentation.list.ListUiStateMapper
import org.junit.Test

import org.junit.Assert.*


class ListUiStateMapperTest {

    private val sut = ListUiStateMapper()

    @Test
    fun `map test from Currency to List item`(){
        val data : List<Currency> =  listOf(Currency("USD",123.0))
        val result = sut.map(data)

        val expected : List<ListItem> = listOf(ListItem("USD", "🇺🇸"))
        assertEquals(expected, result)
    }
}
