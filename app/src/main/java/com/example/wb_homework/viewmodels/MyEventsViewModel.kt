package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.entities.Event
import com.example.domain.usecases.GetEventListUseCase
import com.example.wb_homework.screen_states.MyEventsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyEventsViewModel(
    private val getEventListUseCase: GetEventListUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<MyEventsScreenState>(MyEventsScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    fun getScreenState(): StateFlow<MyEventsScreenState> {
        return screenState
    }

    private var plannedEventList: List<Event>? = null
    private var passedEventList: List<Event>? = null

    fun loadPlannedEventList() {
        if (plannedEventList == null) {
            plannedEventList = getEventListUseCase.invoke().filter {
                !it.finished
            }
        }
        _screenState.value = MyEventsScreenState.PlannedEventList(
            plannedEventList ?: emptyList()
        )
    }

    fun loadPassedEventList() {
        if (passedEventList == null) {
            passedEventList = getEventListUseCase.invoke().filter {
                it.finished
            }
        }
        _screenState.value = MyEventsScreenState.PassedEventList(
            passedEventList ?: emptyList()
        )
    }
}