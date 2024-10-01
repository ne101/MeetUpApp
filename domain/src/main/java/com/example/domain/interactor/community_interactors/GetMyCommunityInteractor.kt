package com.example.domain.interactor.community_interactors

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.GetMyCommunityUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyCommunityInteractor(
    private val repository: CommunityRepository
) : GetMyCommunityUseCase {
    override fun execute(id: Int): Flow<Community> {
        return repository.getMyCommunity(id)
    }
}