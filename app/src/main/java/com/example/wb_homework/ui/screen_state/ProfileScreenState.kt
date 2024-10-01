package com.example.wb_homework.ui.screen_state

import com.example.domain.entities.Profile

sealed class ProfileScreenState {
    data class MainContent(val profile: Profile) : ProfileScreenState()
    data class EditContent(val profile: Profile) : ProfileScreenState()
    data class EditTags(
        val profile: Profile,
        val tags: List<String>,
        val currentTags: List<String>
    ) : ProfileScreenState()
    data class Error(val message: String) : ProfileScreenState()
    data object Initial : ProfileScreenState()
}