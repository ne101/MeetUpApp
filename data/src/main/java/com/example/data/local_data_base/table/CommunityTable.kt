package com.example.data.local_data_base.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("communities")
data class CommunityTable(
    @PrimaryKey
    val id: Int,
    val communityName: String,
    val avatarCommunity: String,
    val tags: List<String>,
)