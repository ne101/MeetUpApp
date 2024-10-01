package com.example.data.local_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local_data_base.table.EventTable
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM events WHERE id = :id")
    fun getMyEvent(id: Int): Flow<EventTable>

    @Query("SELECT * FROM events")
    fun getMyEventList(): Flow<List<EventTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMyEvent(event: EventTable)

    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteMyEvent(id: Int)

    @Query("DELETE FROM events")
    suspend fun deleteAllEvents()

    @Query("SELECT EXISTS(SELECT 1 FROM events WHERE id = :id)")
    fun isEventExists(id: Int): Flow<Boolean>
}