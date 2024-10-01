package com.example.data.local_data_base.converter

import androidx.room.TypeConverter
import com.example.data.local_data_base.table.TagsTable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TagsConvertor {
    @TypeConverter
    fun fromTags(tags: TagsTable): String {
        val gson = Gson()
        val type = object : TypeToken<TagsTable>() {}.type
        return gson.toJson(tags)
    }

    @TypeConverter
    fun toTags(tagsString: String): TagsTable {
        val gson = Gson()
        val type = object : TypeToken<TagsTable>() {}.type
        return gson.fromJson(tagsString, type)
    }
}