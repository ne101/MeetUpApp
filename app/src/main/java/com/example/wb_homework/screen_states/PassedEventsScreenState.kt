package com.example.wb_homework.screen_states

import com.example.domain.entities.Event

sealed class PassedEventsScreenState {

    data object Initial : PassedEventsScreenState()
    data class PassedEventsList(val passedEventsList: List<Event>) : PassedEventsScreenState()

}

