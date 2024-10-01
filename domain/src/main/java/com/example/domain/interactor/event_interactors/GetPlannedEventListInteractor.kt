package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetPlannedEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetPlannedEventListInteractor(
    private val repository: EventRepository
) : GetPlannedEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getPlannedEventList()
    }

}