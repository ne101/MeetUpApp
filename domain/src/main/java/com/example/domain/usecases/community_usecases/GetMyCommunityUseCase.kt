package com.example.domain.usecases.community_usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface GetMyCommunityUseCase {
    fun execute(id: Int): Flow<Community>
}