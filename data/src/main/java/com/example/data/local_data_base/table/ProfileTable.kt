package com.example.data.local_data_base.table

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.local_data_base.converter.CommunityListConverter
import com.example.data.local_data_base.converter.EventListConverter

@Entity(tableName = "profile")
data class ProfileTable(
    @PrimaryKey
    val id: Int = PROFILE_ID,
    val name: String,
    val secondName: String,
    val phone: String,
    val avatar: String,
    val city: String,
    @TypeConverters(EventListConverter::class)
    val events: List<EventTable>,
    @TypeConverters(CommunityListConverter::class)
    val communities: List<CommunityTable>,
    @TypeConverters(TagsTable::class)
    val tags: TagsTable,
    val description: String,
    val habrName: String,
    val telegramName: String,
    val showEvents: Boolean,
    val showCommunities: Boolean
) {
    companion object {
        const val PROFILE_ID = 0
    }
}

