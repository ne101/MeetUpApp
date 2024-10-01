package com.example.data.local_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local_data_base.table.TagsTable
import kotlinx.coroutines.flow.Flow

@Dao
interface TagsDao {
    @Query("SELECT * FROM tags WHERE id = :id")
    fun getMyTags(id: Int = TagsTable.TAGS_ID): Flow<TagsTable?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setMyTags(tags: TagsTable)
}