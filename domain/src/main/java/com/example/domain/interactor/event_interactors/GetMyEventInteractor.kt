package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetMyEventUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyEventInteractor(
    private val repository: EventRepository
) : GetMyEventUseCase {
    override fun execute(id: Int): Flow<Event> {
        return repository.getMyEvent(id)
    }
}