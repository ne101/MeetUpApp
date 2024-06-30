package com.example.wb_homework.more_screen_states

import com.example.wb_homework.domain.Event

sealed class MoreScreenState {
    data object Meets : MoreScreenState()
    data object Profile : MoreScreenState()
    data object Initial : MoreScreenState()
}