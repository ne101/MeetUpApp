package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetActiveEventListUseCase
import com.example.domain.usecases.GetEventListUseCase
import com.example.wb_homework.screen_states.ActiveEventsScreenState
import com.example.wb_homework.screen_states.AllEventsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllEventsViewModel(
    getActiveEventListUseCase: GetActiveEventListUseCase,
    getEventListUseCase: GetEventListUseCase
) : ViewModel() {

    private val _eventsListScreenState = getEventListUseCase.execute().map {
        AllEventsScreenState.AllEventList(it)
    }

    private val _activeEventsListState = getActiveEventListUseCase.execute().map {
        ActiveEventsScreenState.ActiveEventList(it)
    }

    private val eventsListScreenState = _eventsListScreenState
    private val activeEventsListState = _activeEventsListState

    fun getAllEventsListScreenState(): Flow<AllEventsScreenState> {
        return eventsListScreenState
    }

    fun getActiveEventsScreenState(): Flow<ActiveEventsScreenState> {
        return activeEventsListState
    }
}