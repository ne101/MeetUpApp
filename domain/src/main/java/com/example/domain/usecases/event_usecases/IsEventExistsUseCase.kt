package com.example.domain.usecases.event_usecases

import kotlinx.coroutines.flow.Flow

interface IsEventExistsUseCase {
    fun execute(id: Int): Flow<Boolean>
}