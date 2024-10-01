package com.example.domain.interactor.person_interactors

import com.example.domain.entities.Person
import com.example.domain.repository.PersonRepository
import com.example.domain.usecases.person_usecases.GetPersonListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetPersonListInteractor(
    private val repository: PersonRepository
) : GetPersonListUseCase {
    override fun execute(): Flow<List<Person>> {
        return repository.getPersonList()
    }
}