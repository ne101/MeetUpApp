package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetActiveEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetActiveEventListInteractor(
    private val repository: Repository,
) : GetActiveEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getActiveEventList()
    }

}