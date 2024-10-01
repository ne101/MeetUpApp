package com.example.domain.interactor.event_interactors

import com.example.domain.entities.Tags
import com.example.domain.repository.EventRepository
import com.example.domain.usecases.tags_usecases.GetTagsUseCase
import kotlinx.coroutines.flow.Flow

internal class GetTagsInteractor(
    private val repository: EventRepository
) : GetTagsUseCase {
    override fun execute(): Flow<Tags> {
        return repository.getTags()
    }
}