package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetEventListByTagsUseCase
import kotlinx.coroutines.flow.Flow

internal class GetEventListByTagsInteractor(
    private val repository: EventRepository
) : GetEventListByTagsUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getEventListByTags()
    }
}
