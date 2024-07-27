package com.example.domain.i_usecases

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface IGetCommunityListUseCase {
    fun execute(): Flow<List<Community>>
}