package com.example.domain.interactor.community_interactors

import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.FetchCommunityListUseCase

internal class FetchCommunityListInteractor(
    private val repository: CommunityRepository
) : FetchCommunityListUseCase {
    override suspend fun execute() {
        repository.fetchCommunityList()
    }
}