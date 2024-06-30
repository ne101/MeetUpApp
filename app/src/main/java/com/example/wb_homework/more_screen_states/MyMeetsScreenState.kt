package com.example.wb_homework.more_screen_states

import com.example.wb_homework.domain.Event

sealed class MyMeetsScreenState {
    data object Initial : MyMeetsScreenState()
    data class Meets(
        val event: Event
    ) : MyMeetsScreenState()
}