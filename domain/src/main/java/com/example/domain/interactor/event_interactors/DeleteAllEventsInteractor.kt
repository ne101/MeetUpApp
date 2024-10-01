package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.DeleteAllEventsUseCase

internal class DeleteAllEventsInteractor(
    private val repository: EventRepository
) : DeleteAllEventsUseCase {
    override suspend fun execute() {
        repository.deleteAllEvents()
    }
}