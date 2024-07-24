package com.example.wb_homework.screen_states

import com.example.domain.entities.Community

sealed class CommunityDetailsScreenState {
    data object Initial : CommunityDetailsScreenState()
    data class CommunityDetails(val community: Community) : CommunityDetailsScreenState()
}