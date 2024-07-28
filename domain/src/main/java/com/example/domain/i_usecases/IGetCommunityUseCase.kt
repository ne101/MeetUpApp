package com.example.domain.i_usecases

import com.example.domain.entities.Community
import com.example.domain.entities.Event
import kotlinx.coroutines.flow.Flow

interface IGetCommunityUseCase {
    fun execute(): Flow<Community>
}