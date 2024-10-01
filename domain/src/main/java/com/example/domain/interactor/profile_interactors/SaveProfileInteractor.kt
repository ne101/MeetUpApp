package com.example.domain.interactor.profile_interactors

import com.example.domain.entities.Profile
import com.example.domain.repository.ProfileRepository
import com.example.domain.usecases.profile_usecases.SaveProfileUseCase

class SaveProfileInteractor(
    private val repository: ProfileRepository
) : SaveProfileUseCase {
    override suspend fun execute(profile: Profile) {
        repository.saveProfile(profile)
    }
}