package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.DeleteMyEventUseCase

class DeleteMyEventInteractor(
    private val repository: EventRepository
) : DeleteMyEventUseCase {
    override suspend fun execute(id: Int) {
        repository.deleteMyEvent(id)
    }
}