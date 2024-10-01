package com.example.domain.interactor.community_interactors

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.community_usecases.GetCommunityListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityListInteractor(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override fun execute(): Flow<List<Community>> {
        return repository.getCommunityList()
    }
}