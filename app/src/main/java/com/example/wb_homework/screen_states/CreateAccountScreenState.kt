package com.example.wb_homework.screen_states

import com.example.domain.entities.Profile

sealed class CreateAccountScreenState() {
    data object Initial : CreateAccountScreenState()
    data class UserData(
        val profile: Profile
    ) : CreateAccountScreenState()
}