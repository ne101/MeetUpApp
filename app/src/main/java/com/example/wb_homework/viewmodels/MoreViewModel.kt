package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetProfileUseCase
import com.example.wb_homework.screen_states.MoreScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class MoreViewModel(
    private val getProfileUseCase: GetProfileUseCase,
) : ViewModel() {
    private val _screenState = getProfileUseCase.execute().map {
        MoreScreenState.ProfileInfo(it)
    }
    private val screenState = _screenState

    fun getScreenState(): Flow<MoreScreenState> {
        return screenState
    }

}