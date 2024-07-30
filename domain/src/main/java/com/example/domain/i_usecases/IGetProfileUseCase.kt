package com.example.domain.i_usecases

import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow

interface IGetProfileUseCase {
    fun execute(): Flow<Profile>
}