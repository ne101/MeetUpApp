package com.example.data.local_data_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "profile")
data class ProfileTable(
    @PrimaryKey
    val id: Int = PROFILE_ID,
    val name: String,
    val secondName: String,
    val phone: String,
    val avatar: String,
    @TypeConverters(EventListConverter::class)
    val events: List<EventTable>,
) {
    companion object {
        const val PROFILE_ID = 0
    }
}
