package com.example.domain.interactor.person_interactors

import com.example.domain.repository.PersonRepository
import com.example.domain.usecases.person_usecases.FetchPersonListUseCase

internal class FetchPersonListInteractor(
    private val repository: PersonRepository
) : FetchPersonListUseCase {
    override suspend fun execute(eventId: Int) {
        repository.fetchPersonList(eventId)
    }
}