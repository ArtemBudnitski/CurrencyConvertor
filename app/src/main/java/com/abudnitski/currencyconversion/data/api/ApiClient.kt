package com.abudnitski.currencyconversion.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val KEY = "cur_live_Wbah37QTauJGvmyADKHBS32lo5KU9pJdPJrPjege"
    private const val BASE_URL = "https://api.currencyapi.com/v3/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
