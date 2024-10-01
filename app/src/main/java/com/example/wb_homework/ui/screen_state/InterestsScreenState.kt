package com.example.wb_homework.ui.screen_state

import com.example.wb_homework.ui.state.ButtonState

sealed class InterestsScreenState {
    data class MainContent(
        val tags: List<String>,
        val mainButtonState: ButtonState,
        val myTags: List<String>,
        val currentTags: List<String>
    ) : InterestsScreenState()
    data object Initial : InterestsScreenState()
    data class Error(val message: String) : InterestsScreenState()
}