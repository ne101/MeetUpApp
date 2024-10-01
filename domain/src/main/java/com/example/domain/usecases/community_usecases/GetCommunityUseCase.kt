package com.example.domain.usecases.community_usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface GetCommunityUseCase {
    fun execute(): Flow<Community>
}