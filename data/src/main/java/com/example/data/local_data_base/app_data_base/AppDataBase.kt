package com.example.data.local_data_base.app_data_base

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local_data_base.converter.CommunityListConverter
import com.example.data.local_data_base.converter.Converters
import com.example.data.local_data_base.converter.EventListConverter
import com.example.data.local_data_base.converter.TagsConvertor
import com.example.data.local_data_base.dao.CommunityDao
import com.example.data.local_data_base.dao.EventDao
import com.example.data.local_data_base.dao.ProfileDao
import com.example.data.local_data_base.dao.TagsDao
import com.example.data.local_data_base.table.CommunityTable
import com.example.data.local_data_base.table.EventTable
import com.example.data.local_data_base.table.ProfileTable
import com.example.data.local_data_base.table.TagsTable

@Database(
    entities = [
        ProfileTable::class,
        EventTable::class,
        CommunityTable::class,
        TagsTable::class
    ],
    version = 4,
    exportSchema = false
)
@TypeConverters(
    EventListConverter::class,
    CommunityListConverter::class,
    TagsConvertor::class,
    Converters::class
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun eventDao(): EventDao
    abstract fun communityDao(): CommunityDao
    abstract fun tagsDao(): TagsDao

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