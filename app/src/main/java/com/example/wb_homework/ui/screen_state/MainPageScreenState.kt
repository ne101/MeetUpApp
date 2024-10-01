package com.example.wb_homework.ui.screen_state

import com.example.domain.entities.Community
import com.example.domain.entities.Event

sealed class MainPageScreenState {
    data class MainContent(
        val events: List<Event>,
        val comingEvents: List<Event>,
        val allTags: List<String>,
        val currentTags: List<String>,
        val eventsByTags: List<Event>,
        val communities: List<Community>,
        val myCommunities: List<Community>
    ) : MainPageScreenState()

    data class Error(val message: String) : MainPageScreenState()

    data object Initial : MainPageScreenState()

}