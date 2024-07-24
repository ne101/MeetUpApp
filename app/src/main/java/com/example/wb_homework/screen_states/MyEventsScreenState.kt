package com.example.wb_homework.screen_states

import com.example.domain.entities.Event

sealed class MyEventsScreenState {

    data object Initial : MyEventsScreenState()
    data class PlannedEventList(val plannedEventList: List<Event>) : MyEventsScreenState()
    data class PassedEventList(val passedEventList: List<Event>) : MyEventsScreenState()

}