package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetPassedEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetPassedEventListInteractor(
    private val repository: EventRepository,
) : GetPassedEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getPassedEventList()
    }
}