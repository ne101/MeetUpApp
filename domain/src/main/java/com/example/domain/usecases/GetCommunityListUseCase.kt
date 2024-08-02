package com.example.domain.usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface GetCommunityListUseCase {
    fun execute(): Flow<List<Community>>
}