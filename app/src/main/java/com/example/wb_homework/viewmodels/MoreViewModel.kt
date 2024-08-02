package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local_data_base.ProfileTable.Companion.PROFILE_ID
import com.example.domain.usecases.GetProfileUseCase
import com.example.wb_homework.screen_states.MoreScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MoreViewModel(
    private val getProfileUseCase: GetProfileUseCase,
) : ViewModel() {
    private val _screenState = getProfileUseCase.execute(PROFILE_ID).map {
        MoreScreenState.ProfileInfo(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = MoreScreenState.Initial
    )
    private val screenState = _screenState

    fun getScreenStateFlow(): StateFlow<MoreScreenState> {
        return screenState
    }

}