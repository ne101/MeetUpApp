package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetActiveEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetActiveEventListUseCase(private val repository: Repository): IGetActiveEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getActiveEventList()
    }

}