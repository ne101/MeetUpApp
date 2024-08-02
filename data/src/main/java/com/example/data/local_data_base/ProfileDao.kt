package com.example.data.local_data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profile: ProfileTable)

    @Query("SELECT * FROM profile WHERE id = :id")
    fun getProfile(id: Int): Flow<ProfileTable>

    @Query("DELETE FROM profile WHERE id = :id")
    suspend fun deleteProfile(id: Int)

    @Query("SELECT * FROM events WHERE id = :id")
    fun getMyEvent(id: Int): Flow<EventTable>

    @Query("SELECT * FROM events")
    fun getMyEventList(): Flow<List<EventTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMyEvent(event: EventTable)

    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteMyEvent(id: Int)
}
