package com.example.wb_homework.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.wb_homework.domain.entities.Event
import com.example.wb_homework.domain.usecases.GetEventListUseCase
import com.example.wb_homework.screen_states.AllEventsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllEventsViewModel(
    private val getEventListUseCase: GetEventListUseCase,
) : ViewModel() {

    private val _screenState = MutableStateFlow<AllEventsScreenState>(AllEventsScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    private var allEvents: List<Event>? = null
    private var activeEvents: List<Event>? = null

    fun getScreenState(): StateFlow<AllEventsScreenState> {
        return screenState
    }

    fun loadAllEvents() {
        if (allEvents == null) {
            allEvents = getEventListUseCase.invoke()
        }
        _screenState.value = AllEventsScreenState.AllEventList(allEvents ?: emptyList())
    }

    fun loadActiveEvents() {
        if (activeEvents == null) {
            activeEvents = getEventListUseCase.invoke().filter {
                !it.finished
            }
        }
        _screenState.value = AllEventsScreenState.ActiveEventList(
            activeEvents ?: emptyList()
        )
    }
}