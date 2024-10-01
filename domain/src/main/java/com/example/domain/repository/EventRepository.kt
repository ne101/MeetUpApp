package com.example.domain.repository

import com.example.domain.entities.Event
import com.example.domain.entities.Tags
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    fun getEvent(): Flow<Event>
    suspend fun fetchEvent(id: Int)
    suspend fun fetchEventList()
    fun getActiveEventList(): Flow<List<Event>>
    fun getAllEventList(): Flow<List<Event>>
    fun getPlannedEventList(): Flow<List<Event>>
    fun getPassedEventList(): Flow<List<Event>>
    suspend fun deleteAllEvents()
    fun getMyEvent(id: Int): Flow<Event>
    fun getMyEventList(): Flow<List<Event>>
    suspend fun addMyEvent(event: Event)
    suspend fun deleteMyEvent(id: Int)
    fun isEventExists(id: Int): Flow<Boolean>
    fun getEventList(): Flow<List<Event>>
    fun getComingEventList(): Flow<List<Event>>
    fun getEventListByTags(): Flow<List<Event>>
    fun getCommunityEvents(communityId: Int): Flow<List<Event>>

    fun getTags(): Flow<Tags>
    suspend fun setFilterTags(tags: List<String>)
}