package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetProfileUseCase
import com.example.wb_homework.screen_states.MoreScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoreViewModel(
    private val getProfileUseCase: GetProfileUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow<MoreScreenState>(MoreScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<MoreScreenState> {
        return screenState
    }

    fun loadProfileInfo() {
        _screenState.value = MoreScreenState.ProfileInfo(getProfileUseCase.invoke())
    }
}