package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.wb_homework.domain.usecases.GetProfileUseCase
import com.example.wb_homework.screen_states.ProfileScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<ProfileScreenState> {
        return screenState
    }

    fun loadProfile() {
        _screenState.value = ProfileScreenState.ProfileInfo(getProfileUseCase.invoke())
    }
}