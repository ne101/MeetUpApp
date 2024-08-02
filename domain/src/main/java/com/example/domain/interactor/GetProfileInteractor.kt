package com.example.domain.interactor

import com.example.domain.entities.Profile
import com.example.domain.usecases.GetProfileUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetProfileInteractor(
    private val repository: Repository
) : GetProfileUseCase{
    override fun execute(id: Int): Flow<Profile> {
        return repository.getProfile(id)
    }

}