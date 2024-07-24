package com.example.domain.usecases

import com.example.domain.repository.Repository

class GetProfileUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getProfile()
}