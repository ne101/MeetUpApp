package com.example.wb_homework.ui.screen_state

import com.example.domain.entities.Person

sealed class PersonScreenState {
    data class MainContent(val persons: List<Person>) : PersonScreenState()
    data object Initial : PersonScreenState()
    data class Error(val message: String) : PersonScreenState()
}