package com.example.wb_homework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wb_homework.more_screen_states.ProfileScreenState

class ProfileScreenViewModel : ViewModel() {
    private val _screenState = MutableLiveData<ProfileScreenState>(ProfileScreenState.Initial)
}