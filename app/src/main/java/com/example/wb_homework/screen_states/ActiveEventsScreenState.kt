package com.example.wb_homework.screen_states

import com.example.domain.entities.Event

sealed class ActiveEventsScreenState {

    data object Initial : ActiveEventsScreenState()
    data class ActiveEventList(val activeEventList: List<Event>) : ActiveEventsScreenState()

}