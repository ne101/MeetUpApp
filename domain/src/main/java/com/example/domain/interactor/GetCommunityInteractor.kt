package com.example.domain.interactor

import com.example.domain.entities.Community
import com.example.domain.usecases.GetCommunityUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetCommunityInteractor(
    private val repository: Repository
) : GetCommunityUseCase {
    override fun execute(id: Int): Flow<Community> {
        return repository.getCommunity(id)
    }
}