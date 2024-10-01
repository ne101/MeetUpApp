package com.example.domain.usecases.person_usecases

import com.example.domain.entities.Person
import kotlinx.coroutines.flow.Flow

interface GetPersonListUseCase {
    fun execute(): Flow<List<Person>>
}