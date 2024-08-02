package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetPassedEventListUseCase
import com.example.domain.usecases.GetPlannedEventListUseCase
import com.example.wb_homework.screen_states.PassedEventsScreenState
import com.example.wb_homework.screen_states.PlannedEventsScreenState
import com.example.wb_homework.screen_states.TabIndexState
import com.example.wb_homework.ui.screens.FIRST_TAB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MyEventsViewModel(
    private val getPlannedEventListUseCase: GetPlannedEventListUseCase,
    private val getPassedEventListUseCase: GetPassedEventListUseCase,
) : ViewModel() {
    private val _plannedEventsListScreenState = getPlannedEventListUseCase.execute().map {
        PlannedEventsScreenState.PlannedEventsList(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = PlannedEventsScreenState.Initial
    )

    private val _passedEventsListState = getPassedEventListUseCase.execute().map {
        PassedEventsScreenState.PassedEventsList(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = PassedEventsScreenState.Initial
    )

    private val _currentTabIndex = MutableStateFlow<TabIndexState>(
        TabIndexState
            .CurrentTabIndex(
                FIRST_TAB
            )
    )
    private val currentTabIndex = _currentTabIndex.asStateFlow()

    private val plannedEventsListScreenState = _plannedEventsListScreenState
    private val passedEventsListState = _passedEventsListState

    fun getCurrentTabIndexFlow() = currentTabIndex

    fun setCurrentTabIndex(index: Int) {
        _currentTabIndex.value = TabIndexState.CurrentTabIndex(index)
    }

    fun getPlannedEventsListScreenStateFlow(): StateFlow<PlannedEventsScreenState> {
        return plannedEventsListScreenState
    }

    fun getPassedEventsListScreenStateFlow(): StateFlow<PassedEventsScreenState> {
        return passedEventsListState
    }
}