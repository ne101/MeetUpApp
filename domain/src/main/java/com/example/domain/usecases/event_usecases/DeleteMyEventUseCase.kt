package com.example.domain.usecases.event_usecases

interface DeleteMyEventUseCase {
    suspend fun execute(id: Int)
}