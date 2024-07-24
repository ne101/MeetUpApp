package com.example.domain.usecases

import com.example.domain.repository.Repository

class GetCommunityListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCommunityList()
}