package com.example.domain.usecases

import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow

interface GetProfileUseCase {
    fun execute(id: Int): Flow<Profile>
}