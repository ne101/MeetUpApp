package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.repository.Repository
import com.example.domain.usecases.AddMyEventUseCase

class AddMyEventInteractor(
    private val repository: Repository
) : AddMyEventUseCase {
    override suspend fun execute(event: Event) {
        repository.addMyEvent(event)
    }
}