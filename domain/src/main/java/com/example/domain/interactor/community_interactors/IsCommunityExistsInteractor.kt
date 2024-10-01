package com.example.domain.interactor.community_interactors

import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.IsCommunityExistsUseCase
import kotlinx.coroutines.flow.Flow

internal class IsCommunityExistsInteractor(
    private val repository: CommunityRepository
) : IsCommunityExistsUseCase {
    override fun execute(id: Int): Flow<Boolean> {
        return repository.isCommunityExists(id)
    }
}