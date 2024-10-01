package com.example.domain.usecases.profile_usecases

import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow

interface GetProfileUseCase {
    fun execute(): Flow<Profile>
}