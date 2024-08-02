package com.example.domain.usecases

import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface GetMyEventUseCase {
    fun execute(id: Int): Flow<Event>
}