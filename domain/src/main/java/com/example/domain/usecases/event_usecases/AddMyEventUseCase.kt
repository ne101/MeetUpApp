package com.example.domain.usecases.event_usecases

import com.example.domain.entities.Event

interface AddMyEventUseCase {
    suspend fun execute(event: Event)
}