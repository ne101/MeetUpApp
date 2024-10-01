package com.example.domain.usecases.person_usecases

interface FetchPersonListUseCase {
    suspend fun execute(eventId: Int)
}