package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local_data_base.ProfileTable.Companion.PROFILE_ID
import com.example.domain.usecases.DeleteProfileUseCase
import com.example.domain.usecases.GetProfileUseCase
import com.example.wb_homework.screen_states.ProfileScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase
) : ViewModel() {
    private val _screenState = getProfileUseCase.execute(PROFILE_ID).map {
        ProfileScreenState.ProfileInfo(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = ProfileScreenState.Initial
    )
    private val screenState = _screenState

    fun getScreenStateFlow(): StateFlow<ProfileScreenState> {
        return screenState
    }

    fun logOut() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteProfileUseCase.execute(PROFILE_ID)
        }
    }
}