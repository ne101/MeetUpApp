package com.example.data.local_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local_data_base.table.CommunityTable
import kotlinx.coroutines.flow.Flow

@Dao
interface CommunityDao {
    @Query("SELECT * FROM communities WHERE id = :id")
    fun getMyCommunity(id: Int): Flow<CommunityTable>

    @Query("SELECT * FROM communities")
    fun getMyCommunityList(): Flow<List<CommunityTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMyCommunity(community: CommunityTable)

    @Query("DELETE FROM communities WHERE id = :id")
    suspend fun deleteMyCommunity(id: Int)

    @Query("DELETE FROM communities")
    suspend fun deleteAllCommunities()

    @Query("SELECT EXISTS(SELECT 1 FROM communities WHERE id = :id)")
    fun isCommunityExists(id: Int): Flow<Boolean>
}