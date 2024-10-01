package com.example.domain.interactor.event_interactors

import com.example.domain.repository.EventRepository
import com.example.domain.usecases.tags_usecases.SetFilterTagsUseCase

internal class SetFilterTagsInteractor(
    private val repository: EventRepository
): SetFilterTagsUseCase {

    override suspend fun execute(tags: List<String>) {
        repository.setFilterTags(tags)
    }
}