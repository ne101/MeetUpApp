package com.example.domain.usecases.tags_usecases

interface SetMyTagsUseCase {
    suspend fun execute(tags: List<String>)
}