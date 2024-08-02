package com.example.domain.usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface GetCommunityUseCase {
    fun execute(id: Int): Flow<Community>
}