package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetEventUseCase
import kotlinx.coroutines.flow.Flow

internal class GetEventInteractor(
    private val repository: EventRepository
) : GetEventUseCase {
    override fun execute(): Flow<Event> {
        return repository.getEvent()
    }
}