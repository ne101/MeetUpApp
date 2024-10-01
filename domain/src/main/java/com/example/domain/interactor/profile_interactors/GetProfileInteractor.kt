package com.example.domain.interactor.profile_interactors

import com.example.domain.entities.Profile
import com.example.domain.repository.ProfileRepository
import com.example.domain.usecases.profile_usecases.GetProfileUseCase
import kotlinx.coroutines.flow.Flow

internal class GetProfileInteractor(
    private val repository: ProfileRepository
) : GetProfileUseCase {
    override fun execute(): Flow<Profile> {
        return repository.getProfile()
    }

}