package com.example.domain.usecases.community_usecases

interface DeleteMyCommunityUseCase {
    suspend fun execute(id: Int)
}