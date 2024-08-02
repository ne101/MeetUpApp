package com.example.wb_homework.screen_states

sealed class MyEventsScreenState {

    data object Initial : MyEventsScreenState()
    data class CurrentTabIndex(val currentBabIndex: Int) : MyEventsScreenState()

}