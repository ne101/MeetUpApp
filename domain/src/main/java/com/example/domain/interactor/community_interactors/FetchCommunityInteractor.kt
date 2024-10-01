package com.example.domain.interactor.community_interactors

import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.FetchCommunityUseCase

internal class FetchCommunityInteractor(
    private val repository: CommunityRepository
) : FetchCommunityUseCase {
    override suspend fun execute(id: Int) {
        repository.fetchCommunity(id)
    }
}