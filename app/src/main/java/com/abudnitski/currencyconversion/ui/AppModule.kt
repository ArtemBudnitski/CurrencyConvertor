package com.abudnitski.currencyconversion.ui

import android.content.Context
import android.content.SharedPreferences
import com.abudnitski.currencyconversion.R
import com.abudnitski.currencyconversion.data.CurrencyRepository
import com.abudnitski.currencyconversion.data.api.ApiClient
import com.abudnitski.currencyconversion.data.api.ApiService
import com.abudnitski.currencyconversion.data.db.AppDatabase
import com.abudnitski.currencyconversion.data.db.CurrencyDao
import com.abudnitski.currencyconversion.domain.CurrencyMapper
import com.abudnitski.currencyconversion.presentation.list.ListUiStateMapper
import com.abudnitski.currencyconversion.presentation.main.Calculator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideCurrencyRepository(
        currencyDao: CurrencyDao,
        apiService: ApiService,
        currencyMapper: CurrencyMapper,
        sharedPref: SharedPreferences
    ): CurrencyRepository {
        return CurrencyRepository(currencyDao, apiService, currencyMapper, sharedPref)
    }

    @Provides
    fun provideCurrencyDao(database: AppDatabase): CurrencyDao {
        return database.currencyDao()
    }

    @Provides
    fun provideApiService(): ApiService {
        return ApiClient.retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideCurrencyMapper(): CurrencyMapper {
        return CurrencyMapper()
    }

    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.preferences_file), Context.MODE_PRIVATE
        )
    }

    @Provides
    fun provideListUiStateMapper(): ListUiStateMapper {
        return ListUiStateMapper()
    }

    @Provides
    fun provideDataBase(sharedPref: SharedPreferences, @ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context, sharedPref)
    }

    @Provides
    fun provideCalculator(): Calculator {
        return Calculator()
    }
}