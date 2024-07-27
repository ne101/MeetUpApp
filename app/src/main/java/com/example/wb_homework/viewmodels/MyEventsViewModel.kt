package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetPassedEventListUseCase
import com.example.domain.usecases.GetPlannedEventListUseCase
import com.example.wb_homework.screen_states.ActiveEventsScreenState
import com.example.wb_homework.screen_states.PassedEventsScreenState
import com.example.wb_homework.screen_states.PlannedEventsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyEventsViewModel(
    private val getPlannedEventListUseCase: GetPlannedEventListUseCase,
    private val getPassedEventListUseCase: GetPassedEventListUseCase
) : ViewModel() {
    private val _plannedEventsListScreenState = getPlannedEventListUseCase.execute().map {
        PlannedEventsScreenState.PlannedEventsList(it)
    }

    private val _passedEventsListState = getPassedEventListUseCase.execute().map {
        PassedEventsScreenState.PassedEventsList(it)
    }

    private val plannedEventsListScreenState = _plannedEventsListScreenState
    private val passedEventsListState = _passedEventsListState

    fun getPlannedEventsListScreenState(): Flow<PlannedEventsScreenState> {
        return plannedEventsListScreenState
    }

    fun getPassedEventsListScreenState(): Flow<PassedEventsScreenState> {
        return passedEventsListState
    }
}