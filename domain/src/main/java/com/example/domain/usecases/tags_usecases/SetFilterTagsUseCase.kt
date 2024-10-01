package com.example.domain.usecases.tags_usecases

interface SetFilterTagsUseCase {
    suspend fun execute(tags: List<String>)
}