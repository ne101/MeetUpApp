package com.example.domain.usecases.event_usecases

interface FetchEventUseCase {
    suspend fun execute(id: Int)
}