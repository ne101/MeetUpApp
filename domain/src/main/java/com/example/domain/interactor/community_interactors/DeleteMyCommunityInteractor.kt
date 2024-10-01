package com.example.domain.interactor.community_interactors

import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.DeleteMyCommunityUseCase

internal class DeleteMyCommunityInteractor(
    private val repository: CommunityRepository
) : DeleteMyCommunityUseCase {
    override suspend fun execute(id: Int) {
        repository.deleteMyCommunity(id)
    }
}