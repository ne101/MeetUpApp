package com.example.domain.usecases.community_usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface GetMyCommunityListUseCase {
    fun execute(): Flow<List<Community>>
}