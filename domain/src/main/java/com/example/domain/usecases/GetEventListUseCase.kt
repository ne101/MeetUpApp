package com.example.domain.usecases

import com.example.domain.entities.Event
import com.example.domain.repository.Repository

class GetEventListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getEventList()
}
