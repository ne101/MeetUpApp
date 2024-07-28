package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetPassedEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetPassedEventListUseCase(private val repository: Repository) : IGetPassedEventListUseCase{
    override fun execute(): Flow<List<Event>> {
        return repository.getPassedEventList()
    }
}