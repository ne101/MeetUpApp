package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetEventUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetEventUseCase(private val repository: Repository) : IGetEventUseCase {
    override fun execute(): Flow<Event> {
        return repository.getEvent()
    }
}