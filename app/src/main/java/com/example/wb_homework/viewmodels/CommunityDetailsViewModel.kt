package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetCommunityUseCase
import com.example.wb_homework.screen_states.CommunityDetailsScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CommunityDetailsViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    communityId: Int
) : ViewModel() {
    private val _screenState = getCommunityUseCase.execute(communityId).map {
        CommunityDetailsScreenState.CommunityDetails(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = CommunityDetailsScreenState.Initial
    )
    private val screenState = _screenState

    fun getScreenStateFlow(): StateFlow<CommunityDetailsScreenState> {
        return screenState
    }


}