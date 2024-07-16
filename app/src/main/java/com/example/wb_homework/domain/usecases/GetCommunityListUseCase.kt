package com.example.wb_homework.domain.usecases

import com.example.wb_homework.domain.repository.Repository

class GetCommunityListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCommunityList()
}