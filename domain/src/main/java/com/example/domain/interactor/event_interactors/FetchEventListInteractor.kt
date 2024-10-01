package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.FetchEventListUseCase

internal class FetchEventListInteractor(
    private val repository: EventRepository
) : FetchEventListUseCase {
    override suspend fun execute() {
        repository.fetchEventList()
    }
}