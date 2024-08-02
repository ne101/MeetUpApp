package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetCommunityListUseCase
import com.example.wb_homework.screen_states.CommunityScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CommunityViewModel(
    private val getCommunityListUseCase: GetCommunityListUseCase,
) : ViewModel() {
    private val _screenState = getCommunityListUseCase.execute().map {
        CommunityScreenState.CommunityList(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = CommunityScreenState.Initial
    )
    private val screenState = _screenState

    fun getScreenStateFlow(): StateFlow<CommunityScreenState> {
        return screenState
    }

}