package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetEventListUseCase
import com.example.domain.repository.Repository
import com.example.domain.usecases.GetMyEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyEventListInteractor(
    private val repository: Repository
) : GetMyEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getMyEventList()
    }
}
