package com.abudnitski.currencyconversion.data.api

import java.math.BigDecimal

data class CurrencyNet(
    val meta: Meta? = null,
    val data: Map<String, CurrencyTwo> = emptyMap()
)

data class Meta(
    @Suppress("PropertyName")
    val last_updated_at: String = "",
)

data class CurrencyTwo(
    val code: String? = null,
    val value: BigDecimal? = null
)
