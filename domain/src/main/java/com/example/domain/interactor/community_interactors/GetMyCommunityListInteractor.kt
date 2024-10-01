package com.example.domain.interactor.community_interactors

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.GetMyCommunityListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyCommunityListInteractor(
    private val repository: CommunityRepository
) : GetMyCommunityListUseCase {
    override fun execute(): Flow<List<Community>> {
        return repository.getMyCommunityList()
    }
}