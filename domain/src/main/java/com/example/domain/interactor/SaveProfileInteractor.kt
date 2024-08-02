package com.example.domain.interactor

import com.example.domain.entities.Profile
import com.example.domain.repository.Repository
import com.example.domain.usecases.SaveProfileUseCase

class SaveProfileInteractor(
    private val repository: Repository
) : SaveProfileUseCase {
    override suspend fun execute(profile: Profile) {
        repository.saveProfile(profile)
    }
}