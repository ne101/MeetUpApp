package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.i_usecases.IGetCommunityUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetCommunityUseCase(private val repository: Repository) : IGetCommunityUseCase {
    override fun execute(): Flow<Community> {
        return repository.getCommunity()
    }
}