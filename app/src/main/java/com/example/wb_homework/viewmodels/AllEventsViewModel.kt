package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetActiveEventListUseCase
import com.example.domain.usecases.GetAllEventListUseCase
import com.example.wb_homework.screen_states.ActiveEventsScreenState
import com.example.wb_homework.screen_states.AllEventsScreenState
import com.example.wb_homework.screen_states.TabIndexState
import com.example.wb_homework.ui.screens.FIRST_TAB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AllEventsViewModel(
    getActiveEventListUseCase: GetActiveEventListUseCase,
    getAllEventListUseCase: GetAllEventListUseCase,
) : ViewModel() {

    private val _eventsListScreenState = getAllEventListUseCase.execute().map {
        AllEventsScreenState.AllEventList(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = AllEventsScreenState.Initial
    )

    private val _activeEventsListState = getActiveEventListUseCase.execute().map {
        ActiveEventsScreenState.ActiveEventList(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = ActiveEventsScreenState.Initial
    )

    private val _currentTabIndex = MutableStateFlow<TabIndexState>(
        TabIndexState.CurrentTabIndex(FIRST_TAB)
    )
    private val currentTabIndex = _currentTabIndex.asStateFlow()
    private val eventsListScreenState = _eventsListScreenState
    private val activeEventsListState = _activeEventsListState

    fun getCurrentTabIndexFlow() = currentTabIndex

    fun setCurrentTabIndex(index: Int) {
        _currentTabIndex.value = TabIndexState.CurrentTabIndex(index)
    }

    fun getAllEventsListScreenStateFlow(): StateFlow<AllEventsScreenState> {
        return eventsListScreenState
    }

    fun getActiveEventsScreenStateFlow(): StateFlow<ActiveEventsScreenState> {
        return activeEventsListState
    }
}