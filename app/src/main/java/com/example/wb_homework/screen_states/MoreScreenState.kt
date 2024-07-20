package com.example.wb_homework.screen_states

import com.example.domain.entities.Profile


sealed class MoreScreenState {
    data object Initial : MoreScreenState()
    data class ProfileInfo(
        val profile: Profile
    ) : MoreScreenState()
}