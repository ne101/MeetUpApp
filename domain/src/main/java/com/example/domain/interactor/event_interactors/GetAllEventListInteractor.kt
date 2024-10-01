package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetAllEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetAllEventListInteractor(
    private val repository: EventRepository,
) : GetAllEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getAllEventList()
    }

}