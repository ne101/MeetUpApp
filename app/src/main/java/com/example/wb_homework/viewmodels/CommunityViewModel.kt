package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.usecases.community_usecases.AddMyCommunityUseCase
import com.example.domain.usecases.community_usecases.DeleteMyCommunityUseCase
import com.example.domain.usecases.community_usecases.FetchCommunityListUseCase
import com.example.domain.usecases.community_usecases.FetchCommunityUseCase
import com.example.domain.usecases.event_usecases.GetCommunityEventsUseCase
import com.example.domain.usecases.community_usecases.GetCommunityUseCase
import com.example.domain.usecases.community_usecases.IsCommunityExistsUseCase
import com.example.wb_homework.ui.screen_state.CommunityScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getCommunityEventsUseCase: GetCommunityEventsUseCase,
    private val isCommunityExistsUseCase: IsCommunityExistsUseCase,
    private val addMyCommunityUseCase: AddMyCommunityUseCase,
    private val deleteMyCommunityUseCase: DeleteMyCommunityUseCase,
    private val fetchCommunityUseCase: FetchCommunityUseCase,
    private val communityId: Int
) : BaseViewModel() {

    private val _screenState = MutableStateFlow<CommunityScreenState>(CommunityScreenState.Initial)
    private val screenState = _screenState.asStateFlow()
    private val communityFlow =
        getCommunityUseCase.execute().stateInViewModelScope(null)
    private val communityEventsFlow =
        getCommunityEventsUseCase.execute(communityId).stateInViewModelScope(null)
    private val isCommunityExists =
        isCommunityExistsUseCase.execute(communityId).stateInViewModelScope(null)
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _screenState.value = CommunityScreenState.Error(exception.message ?: "Unknown error")
    }

    init {
        fetchInitialData()
    }

    fun getScreenState() = screenState

    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            fetchCommunityUseCase.execute(communityId)
            combine(
                communityFlow.filterNotNull(),
                communityEventsFlow.filterNotNull().map { eventList ->
                    eventList.filterNot { it.finished }
                },
                communityEventsFlow.filterNotNull().map { eventList ->
                    eventList.filter { it.finished }
                },
                isCommunityExists.filterNotNull()
            ) { community, events, finishedEvents, isCommunityExists ->
                CommunityScreenState.MainContent(
                    community = community,
                    eventList = events,
                    finishedEventList = finishedEvents,
                    isCommunityExists = isCommunityExists,
                )
            }.collect { newState ->
                _screenState.update { newState }
            }
        }
    }

    fun updateSubscribeStatus(community: Community) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val currentState = _screenState.value as CommunityScreenState.MainContent
            if (currentState.isCommunityExists) {
                deleteMyCommunityUseCase.execute(community.id)
            } else {
                addMyCommunityUseCase.execute(community)
            }
        }
    }
}