package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetEventListInteractor(
    private val repository: Repository
) : GetEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getEventList()
    }

}
