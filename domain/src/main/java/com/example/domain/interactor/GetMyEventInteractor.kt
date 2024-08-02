package com.example.domain.interactor

import com.example.domain.entities.Event
import com.example.domain.usecases.GetMyEventUseCase
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

internal class GetMyEventInteractor(
    private val repository: Repository
) : GetMyEventUseCase {
    override fun execute(id: Int): Flow<Event> {
        return repository.getMyEvent(id)
    }
}