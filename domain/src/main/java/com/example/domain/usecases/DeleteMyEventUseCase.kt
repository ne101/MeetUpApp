package com.example.domain.usecases

interface DeleteMyEventUseCase {
    suspend fun execute(id: Int)
}