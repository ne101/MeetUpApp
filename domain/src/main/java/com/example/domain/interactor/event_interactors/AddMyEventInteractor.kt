package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.AddMyEventUseCase

class AddMyEventInteractor(
    private val repository: EventRepository
) : AddMyEventUseCase {
    override suspend fun execute(event: Event) {
        repository.addMyEvent(event)
    }
}