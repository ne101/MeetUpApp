package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.wb_homework.domain.usecases.GetCommunityListUseCase
import com.example.wb_homework.screen_states.CommunityScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CommunityViewModel(
    private val getCommunityListUseCase: GetCommunityListUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow<CommunityScreenState>(CommunityScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<CommunityScreenState> {
        return screenState
    }

    fun loadCommunityList() {
        _screenState.value = CommunityScreenState.CommunityList(getCommunityListUseCase.invoke())
    }
}