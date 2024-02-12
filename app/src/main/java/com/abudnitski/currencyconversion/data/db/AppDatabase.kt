package com.abudnitski.currencyconversion.data.db

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.abudnitski.currencyconversion.data.CurrencyRepository.Companion.LAST_UPDATE_KEY


@Database(entities = [CurrencyEntity::class], version = 7)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            sharedPref: SharedPreferences
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "currency_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(AppDataBase(sharedPref))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class AppDataBase(
            private val sharedPref: SharedPreferences
        ) : Callback() {
            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                super.onDestructiveMigration(db)
                with(sharedPref.edit()) {
                    putLong(LAST_UPDATE_KEY, 0)
                    apply()
                }
            }
        }
    }
}
