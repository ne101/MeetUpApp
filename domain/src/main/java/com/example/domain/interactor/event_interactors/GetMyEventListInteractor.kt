package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetMyEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyEventListInteractor(
    private val repository: EventRepository
) : GetMyEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getMyEventList()
    }
}
