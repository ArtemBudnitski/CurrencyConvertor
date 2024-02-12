package com.abudnitski.currencyconversion.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencyentity")
    fun getAll(): Flow<List<CurrencyEntity>>

    @Query("SELECT * FROM currencyentity WHERE code = :code")
    fun findByCode(code: String) : CurrencyEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg currencies: CurrencyEntity)

    @Query("DELETE FROM currencyentity")
    suspend fun deleteAll()

    @Delete
    fun delete(currency: CurrencyEntity)
}
