package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.FetchEventUseCase

internal class FetchEventInteractor(
    private val repository: EventRepository
) : FetchEventUseCase {
    override suspend fun execute(id: Int) {
        repository.fetchEvent(id)
    }
}