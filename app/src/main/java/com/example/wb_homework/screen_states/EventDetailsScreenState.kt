package com.example.wb_homework.screen_states

import com.example.domain.entities.Event


sealed class EventDetailsScreenState {
    data object Initial : EventDetailsScreenState()
    data class EventDetails(val event: Event) : EventDetailsScreenState()
}