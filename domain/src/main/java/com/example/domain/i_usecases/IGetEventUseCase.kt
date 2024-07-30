package com.example.domain.i_usecases

import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface IGetEventUseCase {
    fun execute(): Flow<Event>

}