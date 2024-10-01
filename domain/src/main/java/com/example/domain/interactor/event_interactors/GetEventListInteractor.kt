package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetEventListInteractor(
    private val repository: EventRepository
) : GetEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getEventList()
    }

}
