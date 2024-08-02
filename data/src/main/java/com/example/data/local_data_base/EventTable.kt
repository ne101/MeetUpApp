package com.example.data.local_data_base

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
    val chips: List<String>,
    val finished: Boolean,
    val imageList: List<String>,
    val mapUrl: String
)