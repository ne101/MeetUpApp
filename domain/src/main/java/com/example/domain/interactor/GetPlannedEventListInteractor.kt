package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetPlannedEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetPlannedEventListInteractor(
    private val repository: Repository
) : GetPlannedEventListUseCase{
    override fun execute(): Flow<List<Event>> {
        return repository.getPlannedEventList()
    }

}