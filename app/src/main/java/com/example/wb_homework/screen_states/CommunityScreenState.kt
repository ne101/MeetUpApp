package com.example.wb_homework.screen_states

import com.example.wb_homework.domain.entities.Community

sealed class CommunityScreenState {
    data object Initial : CommunityScreenState()
    data class CommunityList(val communityList: List<Community>) : CommunityScreenState()
}