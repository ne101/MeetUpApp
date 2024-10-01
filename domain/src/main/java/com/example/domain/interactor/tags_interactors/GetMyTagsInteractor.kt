package com.example.domain.interactor.tags_interactors

import com.example.domain.entities.Tags
import com.example.domain.repository.TagsRepository
import com.example.domain.usecases.tags_usecases.GetMyTagsUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMyTagsInteractor(
    private val repository: TagsRepository
) : GetMyTagsUseCase {
    override fun execute(): Flow<Tags> {
        return repository.getMyTags()
    }
}