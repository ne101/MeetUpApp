package com.example.domain.interactor.tags_interactors

import com.example.domain.repository.TagsRepository
import com.example.domain.usecases.tags_usecases.SetMyTagsUseCase

internal class SetMyTagsInteractor(
    private val repository: TagsRepository
): SetMyTagsUseCase {
    override suspend fun execute(tags: List<String>) {
        repository.setMyTags(tags)
    }
}