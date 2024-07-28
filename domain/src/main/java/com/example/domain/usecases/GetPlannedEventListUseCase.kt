package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetPlannedEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetPlannedEventListUseCase(private val repository: Repository) : IGetPlannedEventListUseCase{
    override fun execute(): Flow<List<Event>> {
        return repository.getPlannedEventList()
    }

}