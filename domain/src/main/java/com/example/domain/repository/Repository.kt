package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    fun getEvent(): Flow<Event>
    fun getEventList(): Flow<List<Event>>
    fun getActiveEventList(): Flow<List<Event>>
    fun getAllEventList(): Flow<List<Event>>
    fun getPlannedEventList(): Flow<List<Event>>
    fun getPassedEventList(): Flow<List<Event>>
    fun getCommunity(): Flow<Community>
    fun getCommunityList(): Flow<List<Community>>
    fun getProfile(): Flow<Profile>
}