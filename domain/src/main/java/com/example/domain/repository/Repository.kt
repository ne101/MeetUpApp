package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    fun getEvent(id: Int): Flow<Event>
    fun getEventList(): Flow<List<Event>>
    fun getActiveEventList(): Flow<List<Event>>
    fun getAllEventList(): Flow<List<Event>>
    fun getPlannedEventList(): Flow<List<Event>>
    fun getPassedEventList(): Flow<List<Event>>
    fun getCommunity(id: Int): Flow<Community>
    fun getCommunityList(): Flow<List<Community>>
    fun getProfile(id: Int): Flow<Profile>
    suspend fun saveProfile(profile: Profile)
    suspend fun deleteProfile(id: Int)
    fun getMyEvent(id: Int): Flow<Event>
    fun getMyEventList(): Flow<List<Event>>
    suspend fun addMyEvent(event: Event)
    suspend fun deleteMyEvent(id: Int)
}