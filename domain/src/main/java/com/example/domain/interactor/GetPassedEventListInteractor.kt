package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetPassedEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetPassedEventListInteractor(
    private val repository: Repository,
) : GetPassedEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getPassedEventList()
    }
}