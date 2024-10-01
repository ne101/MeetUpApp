package com.example.domain.usecases.tags_usecases

import com.example.domain.entities.Tags
import kotlinx.coroutines.flow.Flow

interface GetTagsUseCase {
    fun execute(): Flow<Tags>
}