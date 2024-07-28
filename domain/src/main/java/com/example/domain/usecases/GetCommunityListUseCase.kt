package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.i_usecases.IGetCommunityListUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetCommunityListUseCase(private val repository: Repository) : IGetCommunityListUseCase {
    override fun execute(): Flow<List<Community>> {
        return repository.getCommunityList()
    }
}