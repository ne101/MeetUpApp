package com.example.domain.usecases.community_usecases

interface FetchCommunityUseCase {
    suspend fun execute(id: Int)
}