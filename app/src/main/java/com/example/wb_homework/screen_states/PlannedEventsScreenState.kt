package com.example.wb_homework.screen_states

import com.example.domain.entities.Event

sealed class PlannedEventsScreenState {

    data object Initial : PlannedEventsScreenState()
    data class PlannedEventsList(val plannedEventsList: List<Event>) : PlannedEventsScreenState()

}

