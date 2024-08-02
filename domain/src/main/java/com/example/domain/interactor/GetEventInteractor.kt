package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetEventUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetEventInteractor(
    private val repository: Repository
) : GetEventUseCase {
    override fun execute(id: Int): Flow<Event> {
        return repository.getEvent(id)
    }
}