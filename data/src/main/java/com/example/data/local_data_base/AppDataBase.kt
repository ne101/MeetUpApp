package com.example.data.local_data_base

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ProfileTable::class, EventTable::class], version = 2, exportSchema = false)
@TypeConverters(EventListConverter::class, Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        private const val DB_NAME = "profile"
        fun getInstance(application: Application): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}