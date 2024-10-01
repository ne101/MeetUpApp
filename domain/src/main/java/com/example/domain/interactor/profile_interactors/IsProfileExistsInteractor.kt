package com.example.domain.interactor.profile_interactors

import com.example.domain.repository.ProfileRepository
import com.example.domain.usecases.profile_usecases.IsProfileExistsUseCase
import kotlinx.coroutines.flow.Flow

internal class IsProfileExistsInteractor(
    private val repository: ProfileRepository
) : IsProfileExistsUseCase {
    override fun execute(): Flow<Boolean> {
        return repository.isProfileExists()
    }
}