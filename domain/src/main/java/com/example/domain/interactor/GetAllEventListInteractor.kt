package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetAllEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetAllEventListInteractor(
    private val repository: Repository,
) : GetAllEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getAllEventList()
    }

}