package com.example.wb_homework.more_screen_states

import com.example.wb_homework.domain.Profile

sealed class ProfileScreenState {
    data object Initial : ProfileScreenState()
    data class ProfileState(
        val profile: Profile
    ) : ProfileScreenState()
}