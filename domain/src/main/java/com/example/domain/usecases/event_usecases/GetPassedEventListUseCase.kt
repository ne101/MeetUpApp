package com.example.domain.usecases.event_usecases

import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface GetPassedEventListUseCase {
    fun execute(): Flow<List<Event>>
}