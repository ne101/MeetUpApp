package com.example.domain.interactor

import com.example.domain.repository.Repository
import com.example.domain.usecases.DeleteMyEventUseCase

class DeleteMyEventInteractor(
    private val repository: Repository
) : DeleteMyEventUseCase{
    override suspend fun execute(id: Int) {
        repository.deleteMyEvent(id)
    }
}