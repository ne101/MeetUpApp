package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetCommunityUseCase
import com.example.wb_homework.screen_states.CommunityDetailsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CommunityDetailsViewModel(
    private val getCommunityUseCase: GetCommunityUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<CommunityDetailsScreenState>(
        CommunityDetailsScreenState.Initial
    )
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<CommunityDetailsScreenState> {
        return screenState
    }

    fun loadCommunity() {
        _screenState.value = CommunityDetailsScreenState.CommunityDetails(getCommunityUseCase.invoke())
    }
}