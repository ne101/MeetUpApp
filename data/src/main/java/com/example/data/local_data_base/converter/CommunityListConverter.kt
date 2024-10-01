package com.example.data.local_data_base.converter

import androidx.room.TypeConverter
import com.example.data.local_data_base.table.CommunityTable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CommunityListConverter {
    @TypeConverter
    fun fromCommunityList(communities: List<CommunityTable>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CommunityTable>>() {}.type
        return gson.toJson(communities, type)
    }

    @TypeConverter
    fun toCommunityList(communitiesString: String): List<CommunityTable> {
        val gson = Gson()
        val type = object : TypeToken<List<CommunityTable>>() {}.type
        return gson.fromJson(communitiesString, type)
    }
}