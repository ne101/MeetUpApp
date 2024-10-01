package com.example.domain.usecases.profile_usecases

import com.example.domain.entities.Profile

interface SaveProfileUseCase {
    suspend fun execute(profile: Profile)
}