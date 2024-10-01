package com.example.domain.repository

import com.example.domain.entities.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun getPersonList(): Flow<List<Person>>
    suspend fun fetchPersonList(eventId: Int)
}