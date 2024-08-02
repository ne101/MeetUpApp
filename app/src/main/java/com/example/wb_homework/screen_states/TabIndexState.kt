package com.example.wb_homework.screen_states

sealed class TabIndexState {
    data class CurrentTabIndex(val currentTabIndex: Int) : TabIndexState()
}