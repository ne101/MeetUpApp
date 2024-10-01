package com.example.domain.interactor.community_interactors

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.AddMyCommunityUseCase

internal class AddMyCommunityInteractor(
    private val repository: CommunityRepository
) : AddMyCommunityUseCase {
    override suspend fun execute(community: Community) {
        repository.addMyCommunity(community)
    }
}