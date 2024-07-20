package com.example.domain.usecases

import com.example.domain.entities.Community
import com.example.domain.repository.Repository

class GetCommunityUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCommunity()
}