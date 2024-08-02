package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Event
import com.example.domain.usecases.AddMyEventUseCase
import com.example.domain.usecases.DeleteMyEventUseCase
import com.example.domain.usecases.GetEventUseCase
import com.example.domain.usecases.GetMyEventListUseCase
import com.example.wb_homework.screen_states.EventDetailsScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EventDetailsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val addMyEventUseCase: AddMyEventUseCase,
    private val deleteMyEventUseCase: DeleteMyEventUseCase,
    private val getMyEventListUseCase: GetMyEventListUseCase,
    private val eventId: Int,
) : ViewModel() {
    private val _screenState = getEventUseCase.execute(eventId).map {
        EventDetailsScreenState.EventDetails(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = EventDetailsScreenState.Initial
    )
    private val checkEventInDB = getMyEventListUseCase.execute().map {
        it.any { event ->
            eventId == event.id
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = false
    )
    private val screenState = _screenState

    fun getScreenStateFlow(): StateFlow<EventDetailsScreenState> {
        return screenState
    }

    fun checkEventInDB() = checkEventInDB

    fun addMyEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            addMyEventUseCase.execute(event)
        }
    }

    fun deleteMyEvent(eventId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMyEventUseCase.execute(eventId)
        }
    }
}