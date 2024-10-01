package com.example.domain.repository

import com.example.domain.entities.Tags
import kotlinx.coroutines.flow.Flow

interface TagsRepository {
    fun getMyTags(): Flow<Tags>
    suspend fun setMyTags(tags: List<String>)
}