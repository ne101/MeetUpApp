package com.example.domain.usecases

import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface GetAllEventListUseCase {
    fun execute(): Flow<List<Event>>
}