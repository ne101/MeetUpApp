package com.example.domain.interactor

import com.example.domain.repository.Repository
import com.example.domain.usecases.DeleteProfileUseCase

class DeleteProfileInteractor(
    private val repository: Repository,
) : DeleteProfileUseCase {
    override suspend fun execute(id: Int) {
        repository.deleteProfile(id)
    }
}