package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetEventListUseCase(private val repository: Repository) : IGetEventListUseCase{
    override fun execute(): Flow<List<Event>> {
        return repository.getEventList()
    }

}
