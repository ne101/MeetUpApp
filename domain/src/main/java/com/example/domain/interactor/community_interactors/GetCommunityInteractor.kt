package com.example.domain.interactor.community_interactors

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.GetCommunityUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityInteractor(
    private val repository: CommunityRepository
) : GetCommunityUseCase {
    override fun execute(): Flow<Community> {
        return repository.getCommunity()
    }
}