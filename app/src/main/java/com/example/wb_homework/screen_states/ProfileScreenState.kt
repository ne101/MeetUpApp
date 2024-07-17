package com.example.wb_homework.screen_states

import com.example.wb_homework.domain.entities.Profile

sealed class ProfileScreenState {
    data object Initial : ProfileScreenState()
    data class ProfileInfo(
        val profile: Profile
    ) : ProfileScreenState()
}