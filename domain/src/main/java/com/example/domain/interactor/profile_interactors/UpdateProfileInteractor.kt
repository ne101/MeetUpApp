package com.example.domain.interactor.profile_interactors

import com.example.domain.entities.Profile
import com.example.domain.repository.ProfileRepository
import com.example.domain.usecases.profile_usecases.UpdateProfileUseCase

internal class UpdateProfileInteractor(
    private val repository: ProfileRepository
) : UpdateProfileUseCase {
    override suspend fun execute(profile: Profile) {
        repository.updateProfile(profile)
    }
}