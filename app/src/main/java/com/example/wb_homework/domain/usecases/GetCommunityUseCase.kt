package com.example.wb_homework.domain.usecases

import com.example.wb_homework.domain.entities.Community
import com.example.wb_homework.domain.repository.Repository

class GetCommunityUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCommunity()
}