package com.example.domain.interactor

import com.example.domain.entities.Community
import com.example.domain.usecases.GetCommunityListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetCommunityListInteractor(
    private val repository: Repository
) : GetCommunityListUseCase {
    override fun execute(): Flow<List<Community>> {
        return repository.getCommunityList()
    }
}