package com.example.domain.usecases.profile_usecases

import com.example.domain.entities.Profile

interface UpdateProfileUseCase {
    suspend fun execute(profile: Profile)
}