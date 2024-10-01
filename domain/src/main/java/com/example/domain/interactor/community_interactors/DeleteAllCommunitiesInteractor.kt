package com.example.domain.interactor.community_interactors

import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.DeleteAllCommunitiesUseCase

internal class DeleteAllCommunitiesInteractor(
    private val repository: CommunityRepository
) : DeleteAllCommunitiesUseCase {
    override suspend fun execute() {
        repository.deleteAllCommunities()
    }
}