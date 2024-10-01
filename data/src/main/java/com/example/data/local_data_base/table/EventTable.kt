package com.example.data.local_data_base.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventTable(
    @PrimaryKey
    val id: Int,
    val eventName: String,
    val date: String,
    val city: String,
    val street: String,
    val avatar: String,
    val tags: List<String>,
    val finished: Boolean,
    val communityId: Int,
)