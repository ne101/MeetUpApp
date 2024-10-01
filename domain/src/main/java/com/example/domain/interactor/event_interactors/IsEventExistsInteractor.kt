package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.event_usecases.IsEventExistsUseCase
import kotlinx.coroutines.flow.Flow

internal class IsEventExistsInteractor(
    private val repository: EventRepository
) : IsEventExistsUseCase {
    override fun execute(id: Int): Flow<Boolean> {
        return repository.isEventExists(id)
    }
}