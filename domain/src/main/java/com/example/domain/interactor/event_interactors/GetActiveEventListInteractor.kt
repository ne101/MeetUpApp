package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetActiveEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetActiveEventListInteractor(
    private val repository: EventRepository,
) : GetActiveEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getActiveEventList()
    }

}