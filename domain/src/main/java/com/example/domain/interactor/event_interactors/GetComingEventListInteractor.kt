package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetComingEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetComingEventListInteractor(
    private val repository: EventRepository
) : GetComingEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getComingEventList()
    }
}