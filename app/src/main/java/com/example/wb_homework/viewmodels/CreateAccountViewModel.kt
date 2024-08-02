package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Profile
import com.example.domain.usecases.SaveProfileUseCase
import com.example.wb_homework.screen_states.CreateAccountScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    private val saveProfileUseCase: SaveProfileUseCase,
) : ViewModel() {

    private val _screenState = MutableStateFlow<CreateAccountScreenState>(
        CreateAccountScreenState.Initial
    )
    private val screenState = _screenState.asStateFlow()

    fun getScreenState() = screenState

    fun updateName(name: String) {
        val currentState = _screenState.value
        if (currentState is CreateAccountScreenState.UserData) {
            val updateData = currentState.profile.copy(name = name)
            _screenState.value = CreateAccountScreenState.UserData(updateData)
        }
    }

    fun updateSecondName(secondName: String) {
        val currentState = _screenState.value
        if (currentState is CreateAccountScreenState.UserData) {
            val updateData = currentState.profile.copy(secondName = secondName)
            _screenState.value = CreateAccountScreenState.UserData(updateData)
        }
    }
    fun updatePhoneNumber(phoneNumber: String) {
        _screenState.value = CreateAccountScreenState.UserData(Profile(avatar = null))
        val currentState = _screenState.value
        if (currentState is CreateAccountScreenState.UserData) {
            val updateData = currentState.profile.copy(phone = phoneNumber)
            _screenState.value = CreateAccountScreenState.UserData(updateData)
        }
    }
    fun saveProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            saveProfileUseCase.execute(profile)
        }
    }

}