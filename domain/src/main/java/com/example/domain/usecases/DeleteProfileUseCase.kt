package com.example.domain.usecases

interface DeleteProfileUseCase {
    suspend fun execute(id: Int)
}