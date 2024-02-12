package com.abudnitski.currencyconversion.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("latest?apikey=${ApiClient.KEY}")
    suspend fun getAllCurrency(@Query("currencies") currencies: String, @Query("base_currency") baseCurrency: String): CurrencyNet
}
