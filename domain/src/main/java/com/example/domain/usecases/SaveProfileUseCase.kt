package com.example.domain.usecases

import com.example.domain.entities.Profile

interface SaveProfileUseCase {
    suspend fun execute(profile: Profile)
}