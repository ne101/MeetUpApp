package com.example.domain.i_usecases

import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface IGetEventListUseCase {
    fun execute(): Flow<List<Event>>
}