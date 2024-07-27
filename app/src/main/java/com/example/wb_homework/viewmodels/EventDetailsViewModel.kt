package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetEventUseCase
import com.example.wb_homework.screen_states.EventDetailsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class EventDetailsViewModel(
    getEventUseCase: GetEventUseCase
) : ViewModel() {
    private val _screenState = getEventUseCase.execute().map {
        EventDetailsScreenState.EventDetails(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = EventDetailsScreenState.Initial
    )
    private val screenState = _screenState

    fun getScreenState(): StateFlow<EventDetailsScreenState> {
        return screenState
    }
}