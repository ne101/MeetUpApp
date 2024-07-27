package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.i_usecases.IGetAllEventListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllEventListUseCase(private val repository: Repository): IGetAllEventListUseCase {
    override fun execute(): Flow<List<Event>> {
        return repository.getAllEventList()
    }

}