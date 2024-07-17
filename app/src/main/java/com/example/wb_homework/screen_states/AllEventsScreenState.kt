package com.example.wb_homework.screen_states

import com.example.wb_homework.domain.entities.Event

sealed class AllEventsScreenState {

    data object Initial : AllEventsScreenState()
    data class AllEventList(val allEventList: List<Event>) : AllEventsScreenState()
    data class ActiveEventList(val activeEventList: List<Event>) : AllEventsScreenState()

}