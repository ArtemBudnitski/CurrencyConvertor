package com.example.currencyconversion

import com.abudnitski.currencyconversion.presentation.main.Calculator
import com.abudnitski.currencyconversion.presentation.main.KeyboardKeys
import org.junit.Test

import org.junit.Assert.*


class CalculatorTest {

    private val sut = Calculator()

    @Test
    fun `Given 0 When percent Then null`() {
        sut.onKeyboardClicked(KeyboardKeys.AC, "0", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.ONE, "0", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.TWO, "1", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.THREE, "12", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.DIV, "123", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.ZERO, "123", RATE_1, RATE_2)

        val result = sut.onKeyboardClicked(KeyboardKeys.PERCENT, "0", RATE_1, RATE_2)


        assertEquals("123", result?.first)
        assertEquals("123.00", result?.second)
    }

    @Test
    fun `Given values When sum Then null`() {
        sut.onKeyboardClicked(KeyboardKeys.AC, "0", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.ONE, "0", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.TWO, "1", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.SUM, "12", RATE_1, RATE_2)
        sut.onKeyboardClicked(KeyboardKeys.FIVE, "0", RATE_1, RATE_2)

        val result = sut.onKeyboardClicked(KeyboardKeys.EQUAL, "5", RATE_1, RATE_2)


        assertEquals("17", result?.first)
        assertEquals("17.00", result?.second)
    }
    @Test
    fun `Given init When equal Then null`() {

        val result = sut.onKeyboardClicked(KeyboardKeys.EQUAL, "0", RATE_1, RATE_2)

        assertEquals("0", result?.first)
        assertEquals("0.00", result?.second)
    }

    private companion object {
        const val RATE_1 = "1"
        const val RATE_2 = "1"

    }
}