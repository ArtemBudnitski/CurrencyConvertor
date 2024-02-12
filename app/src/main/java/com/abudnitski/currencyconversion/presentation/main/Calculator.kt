package com.abudnitski.currencyconversion.presentation.main

import java.math.BigDecimal
import java.util.Locale

class Calculator {

    private var numberOne: BigDecimal? = null
    private var numberTwo: BigDecimal? = null
    private var mathOperator = ""

    fun onKeyboardClicked(
        key: String,
        currencyOneValue: String,
        firstRateValue: String,
        secondRateValue: String
    ): Pair<String, String>? {
        val firstValue = when (key) {
            KeyboardKeys.DELETE -> onDelete(currencyOneValue)

            KeyboardKeys.ONE,
            KeyboardKeys.TWO,
            KeyboardKeys.THREE,
            KeyboardKeys.FOUR,
            KeyboardKeys.FIVE,
            KeyboardKeys.SIX,
            KeyboardKeys.SEVEN,
            KeyboardKeys.EIGHT,
            KeyboardKeys.NINE,
            KeyboardKeys.ZERO -> addNumberOnEnd(key, currencyOneValue)

            KeyboardKeys.SUM,
            KeyboardKeys.SUB,
            KeyboardKeys.DIV,
            KeyboardKeys.MUL -> addSomeMath(key, currencyOneValue)

            KeyboardKeys.AC -> clean()

            KeyboardKeys.EQUAL -> equal(currencyOneValue)

            KeyboardKeys.DOT -> dotFunc(currencyOneValue)

            KeyboardKeys.PERCENT -> percent(currencyOneValue)

            else -> null
        }

        return if (firstValue == null) {
            null
        } else {
            val secondValue = secondCurrencyScreen(firstValue, firstRateValue, secondRateValue)
            Pair(firstValue, secondValue)
        }
    }

    private fun onDelete(currentValue: String): String {
        val deleteLast: String = if (currentValue.length != 1) {
            currentValue.dropLast(1)
        } else {
            "0"
        }
        return deleteLast.take(12)

    }

    private fun addNumberOnEnd(n: String, currentValue: String): String {
        val newCurrentValue: String = if (currentValue.length == 1 && currentValue.contains("0")) {
            n
        } else {
            currentValue + n
        }
        return newCurrentValue.take(12)
    }

    private fun addSomeMath(n: String, currentValue: String): String {
        numberOne = currentValue.toBigDecimalOrNull()
        mathOperator = n
        return "0"
    }

    private fun clean(): String {
        numberOne = null
        numberTwo = null
        mathOperator = ""
        return "0"
    }

    private fun equal(firstCurrencyValue: String): String? {
        var error = false
        numberTwo = firstCurrencyValue.toBigDecimalOrNull()
        var result: BigDecimal? = null
        numberOne?.let { one ->
            numberTwo?.let { two ->
                result = when (mathOperator) {
                    KeyboardKeys.SUM -> one + two
                    KeyboardKeys.SUB -> one - two
                    KeyboardKeys.DIV -> {
                        if (two == BigDecimal.ZERO) {
                            error = true
                            BigDecimal.ZERO
                        } else {
                            one / two
                        }
                    }

                    KeyboardKeys.MUL -> one * two
                    else -> null
                }

            }
        }

        numberOne = result ?: BigDecimal.ZERO
        numberTwo = null
        mathOperator = ""

        return if (error) {
            null
        } else {
            (result ?: BigDecimal.ZERO).toString().take(12)
        }
    }

    private fun percent(firstCurrencyValue: String): String? {
        var error = false
        var result = BigDecimal.ZERO
        numberTwo = firstCurrencyValue.toBigDecimalOrNull()

        if (numberTwo == BigDecimal.ZERO) {
            result = numberOne
        } else {
            numberOne?.let { one ->
                numberTwo?.let { two ->
                    if (one != BigDecimal.ZERO && two != BigDecimal.ZERO) {
                        val rightSide = (two / one) * BigDecimal(100)
                        result = if (rightSide == BigDecimal(0)) {
                            error = true
                            BigDecimal.ZERO
                        } else {
                            when (mathOperator) {
                                KeyboardKeys.SUM -> one + rightSide
                                KeyboardKeys.SUB -> one - rightSide
                                KeyboardKeys.DIV -> one / rightSide
                                KeyboardKeys.MUL -> one * rightSide
                                else -> null
                            }
                        }
                    }
                }
            }
        }


        numberOne = result ?: BigDecimal.ZERO
        numberTwo = null
        mathOperator = ""

        return if (error) {
            null
        } else {
            (result ?: BigDecimal.ZERO).toString().take(12)
        }

    }

    private fun dotFunc(firstCurrencyValue: String): String {
        return if (!firstCurrencyValue.contains(".")) {
            val newState = "$firstCurrencyValue."
            newState
        } else {
            val updatedValue = firstCurrencyValue.replace(".", "")
            updatedValue
        }
    }

    private fun secondCurrencyScreen(firstValue: String, firstRateValue: String, secondRateValue: String): String {
        val secondValue = firstValue.toBigDecimal() * calculateRate(firstRateValue, secondRateValue).toBigDecimal()
        return "%.2f".format(Locale.US, secondValue)
    }

    fun calculateRate(firstRateValue: String, secondRateValue: String): String {
        val firstRate = firstRateValue.toDouble()
        val secondRate = secondRateValue.toDouble()
        val secondCurrencyRate = secondRate / firstRate
        return "%.8f".format(Locale.US, secondCurrencyRate)
    }
}