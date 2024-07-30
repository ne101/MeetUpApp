package com.example.domain.usecases

import com.example.domain.entities.Profile
import com.example.domain.i_usecases.IGetProfileUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetProfileUseCase(private val repository: Repository) : IGetProfileUseCase{
    override fun execute(): Flow<Profile> {
        return repository.getProfile()
    }

}