package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetEventUseCase
import com.example.wb_homework.screen_states.EventDetailsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EventDetailsViewModel(
    private val getEventUseCase: GetEventUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<EventDetailsScreenState>(EventDetailsScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<EventDetailsScreenState> {
        return screenState
    }

    fun loadEvent() {
        _screenState.value = EventDetailsScreenState.EventDetails(getEventUseCase.invoke())
    }
}