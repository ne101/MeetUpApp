package com.example.wb_homework.ui.screen_state

import com.example.domain.entities.Community
import com.example.domain.entities.Event

sealed class CommunityScreenState {
    data class MainContent(
        val community: Community,
        val eventList: List<Event>,
        val finishedEventList: List<Event>,
        val isCommunityExists: Boolean,
    ) : CommunityScreenState()

    data object Initial : CommunityScreenState()

    data class Error(val message: String) : CommunityScreenState()
}