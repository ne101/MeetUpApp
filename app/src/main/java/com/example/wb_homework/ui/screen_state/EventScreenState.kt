package com.example.wb_homework.ui.screen_state

import com.example.domain.entities.Community
import com.example.domain.entities.Event

sealed class EventScreenState {
    data class MainContent(
        val eventsByCommunity: List<Event>,
        val community: Community,
        val event: Event,
        val isEventExists: Boolean,
    ) : EventScreenState()

    data class Error(val message: String) : EventScreenState()

    data object Initial : EventScreenState()
}