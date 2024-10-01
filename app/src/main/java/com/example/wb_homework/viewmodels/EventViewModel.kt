package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Event
import com.example.domain.usecases.community_usecases.FetchCommunityUseCase
import com.example.domain.usecases.event_usecases.AddMyEventUseCase
import com.example.domain.usecases.event_usecases.DeleteMyEventUseCase
import com.example.domain.usecases.event_usecases.FetchEventUseCase
import com.example.domain.usecases.event_usecases.GetCommunityEventsUseCase
import com.example.domain.usecases.community_usecases.GetCommunityUseCase
import com.example.domain.usecases.event_usecases.FetchEventListUseCase
import com.example.domain.usecases.event_usecases.GetEventUseCase
import com.example.domain.usecases.event_usecases.IsEventExistsUseCase
import com.example.wb_homework.ui.screen_state.EventScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val fetchEventUseCase: FetchEventUseCase,
    private val fetchCommunityUseCase: FetchCommunityUseCase,
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getEventsByCommunityUseCase: GetCommunityEventsUseCase,
    private val fetchEventListUseCase: FetchEventListUseCase,
    private val addMyEventUseCase: AddMyEventUseCase,
    private val deleteMyEventUseCase: DeleteMyEventUseCase,
    private val isEventExistsUseCase: IsEventExistsUseCase,
    private val eventId: Int,
    private val communityId: Int
) : BaseViewModel() {
    private val _screenState = MutableStateFlow<EventScreenState>(EventScreenState.Initial)
    private val screenState = _screenState.asStateFlow()
    private val eventFlow = getEventUseCase.execute().stateInViewModelScope(null)
    private val communityFlow =
        getCommunityUseCase.execute().stateInViewModelScope(null)
    private val eventsByCommunity =
        getEventsByCommunityUseCase.execute(communityId).stateInViewModelScope(null)
    private val isEventExistsFlow =
        isEventExistsUseCase.execute(eventId).stateInViewModelScope(null)
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _screenState.value = EventScreenState.Error(exception.message ?: "Unknown error")
    }

    init {
        fetchInitialData()
    }

    fun getScreenStateFlow() = screenState

    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            fetchEventUseCase.execute(eventId)
            fetchCommunityUseCase.execute(communityId)
            fetchEventListUseCase.execute()
            combine(
                eventFlow.filterNotNull(),
                communityFlow.filterNotNull(),
                eventsByCommunity.filterNotNull().map { eventList ->
                    eventList.filterNot { event ->
                        event.id == eventId
                    }
                },
                isEventExistsFlow.filterNotNull()
                ) { event, community, eventsByCommunity, isEventExists ->
                EventScreenState.MainContent(
                    eventsByCommunity = eventsByCommunity,
                    community = community,
                    event = event,
                    isEventExists = isEventExists
                )
            }.collect { newState ->
                _screenState.update { newState }
            }
        }
    }

    fun updateEventSubscribeStatus(event: Event) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val currentState = _screenState.value as EventScreenState.MainContent
            if (currentState.isEventExists) {
                deleteMyEventUseCase.execute(event.id)
            } else {
                addMyEventUseCase.execute(event)
            }
        }
    }

}