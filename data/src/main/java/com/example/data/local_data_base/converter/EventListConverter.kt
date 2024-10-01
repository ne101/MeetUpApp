package com.example.data.local_data_base.converter

import androidx.room.TypeConverter
import com.example.data.local_data_base.table.EventTable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EventListConverter {
    @TypeConverter
    fun fromEventList(events: List<EventTable>): String {
        val gson = Gson()
        val type = object : TypeToken<List<EventTable>>() {}.type
        return gson.toJson(events, type)
    }

    @TypeConverter
    fun toEventList(eventsString: String): List<EventTable> {
        val gson = Gson()
        val type = object : TypeToken<List<EventTable>>() {}.type
        return gson.fromJson(eventsString, type)
    }
}