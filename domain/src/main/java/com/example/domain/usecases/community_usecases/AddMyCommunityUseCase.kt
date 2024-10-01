package com.example.domain.usecases.community_usecases

import com.example.domain.entities.Community

interface AddMyCommunityUseCase {
    suspend fun execute(community: Community)
}