package com.example.domain.usecases.community_usecases

import kotlinx.coroutines.flow.Flow

interface IsCommunityExistsUseCase {
    fun execute(id: Int): Flow<Boolean>
}