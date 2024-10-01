package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.GetCommunityEventsUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityEventsInteractor(
    private val repository: EventRepository
) : GetCommunityEventsUseCase {
    override fun execute(communityId: Int): Flow<List<Event>> {
        return repository.getCommunityEvents(communityId)
    }
}