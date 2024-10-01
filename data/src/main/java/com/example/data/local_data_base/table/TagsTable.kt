package com.example.data.local_data_base.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tags")
data class TagsTable(
    @PrimaryKey
    val id: Int = TAGS_ID,
    val tags: List<String>
) {
    companion object {
        const val TAGS_ID = 0
    }
}