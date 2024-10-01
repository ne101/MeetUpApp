package com.example.domain.usecases.profile_usecases

import kotlinx.coroutines.flow.Flow

interface IsProfileExistsUseCase {
    fun execute(): Flow<Boolean>
}