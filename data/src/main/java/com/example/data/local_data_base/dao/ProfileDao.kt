package com.example.data.local_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local_data_base.table.CommunityTable
import com.example.data.local_data_base.table.EventTable
import com.example.data.local_data_base.table.ProfileTable
import com.example.data.local_data_base.table.TagsTable
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profile: ProfileTable)

    @Query("SELECT * FROM profile WHERE id = :id")
    fun getProfile(id: Int = ProfileTable.PROFILE_ID): Flow<ProfileTable>

    @Query("DELETE FROM profile WHERE id = :id")
    suspend fun deleteProfile(id: Int = ProfileTable.PROFILE_ID)

    @Query("SELECT EXISTS(SELECT 1 FROM profile WHERE id = :id)")
    fun isProfileExists(id: Int = ProfileTable.PROFILE_ID): Flow<Boolean>

    @Update
    suspend fun updateProfile(profile: ProfileTable)
}
