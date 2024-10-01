package com.example.domain.interactor.profile_interactors

import com.example.domain.repository.ProfileRepository
import com.example.domain.usecases.profile_usecases.DeleteProfileUseCase

class DeleteProfileInteractor(
    private val repository: ProfileRepository,
) : DeleteProfileUseCase {
    override suspend fun execute() {
        repository.deleteProfile()
    }
}