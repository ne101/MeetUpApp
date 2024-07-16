package com.example.wb_homework.domain.usecases

import com.example.wb_homework.domain.entities.Event
import com.example.wb_homework.domain.repository.Repository

class GetEventListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getEventList()
}
