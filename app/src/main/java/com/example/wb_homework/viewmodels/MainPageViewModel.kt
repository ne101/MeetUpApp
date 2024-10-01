package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.usecases.community_usecases.AddMyCommunityUseCase
import com.example.domain.usecases.community_usecases.DeleteMyCommunityUseCase
import com.example.domain.usecases.community_usecases.FetchCommunityListUseCase
import com.example.domain.usecases.event_usecases.GetComingEventListUseCase
import com.example.domain.usecases.community_usecases.GetCommunityListUseCase
import com.example.domain.usecases.event_usecases.GetEventListByTagsUseCase
import com.example.domain.usecases.event_usecases.GetEventListUseCase
import com.example.domain.usecases.community_usecases.GetMyCommunityListUseCase
import com.example.domain.usecases.event_usecases.FetchEventListUseCase
import com.example.domain.usecases.tags_usecases.GetTagsUseCase
import com.example.domain.usecases.tags_usecases.SetFilterTagsUseCase
import com.example.wb_homework.ui.screen_state.MainPageScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainPageViewModel(
    private val getTagsUseCase: GetTagsUseCase,
    private val getEventListByTagsUseCase: GetEventListByTagsUseCase,
    private val getComingEventListUseCase: GetComingEventListUseCase,
    private val getEventListUseCase: GetEventListUseCase,
    private val fetchEventListUseCase: FetchEventListUseCase,
    private val getCommunityListUseCase: GetCommunityListUseCase,
    private val fetchCommunityListUseCase: FetchCommunityListUseCase,
    private val addMyCommunityUseCase: AddMyCommunityUseCase,
    private val deleteMyCommunityUseCase: DeleteMyCommunityUseCase,
    private val getMyCommunityListUseCase: GetMyCommunityListUseCase,
    private val setTagsUseCase: SetFilterTagsUseCase,
) : BaseViewModel() {
    private val _screenState = MutableStateFlow<MainPageScreenState>(MainPageScreenState.Initial)
    private val screenState: StateFlow<MainPageScreenState> = _screenState.asStateFlow()

    private val tagsFlow = getTagsUseCase.execute().stateInViewModelScope(null)
    private val eventsFlow = getEventListUseCase.execute().stateInViewModelScope(null)
    private val comingEventsFlow =
        getComingEventListUseCase.execute().stateInViewModelScope(null)
    private val eventsByTagsFlow =
        getEventListByTagsUseCase.execute().stateInViewModelScope(null)
    private val communitiesFlow =
        getCommunityListUseCase.execute().stateInViewModelScope(null)
    private val _currentTagsFlow = MutableStateFlow<List<String>>(emptyList())
    private val currentTagsFlow = _currentTagsFlow.asStateFlow()

    private val myCommunitiesFlow = getMyCommunityListUseCase.execute().stateInViewModelScope(null)

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _screenState.update {
            MainPageScreenState.Error(error.message ?: "Unknown error")
        }
    }

    init {
        fetchInitialData()
    }

    fun getScreenStateFlow() = screenState

    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            fetchEventListUseCase.execute()
            fetchCommunityListUseCase.execute()
            combine(
                combine(
                    tagsFlow.filterNotNull(),
                    eventsFlow.filterNotNull(),
                    comingEventsFlow.filterNotNull()
                ) { tags, events, comingEvents ->
                    Triple(tags, events, comingEvents)
                },
                combine(
                    eventsByTagsFlow.filterNotNull(),
                    communitiesFlow.filterNotNull(),
                    currentTagsFlow
                ) { eventsByTags, communities, currentTags ->
                    Triple(eventsByTags, communities, currentTags)
                },
                myCommunitiesFlow.filterNotNull()
            ) { triple1, triple2, myCommunities ->
                val (tags, events, comingEvents) = triple1
                val (eventsByTags, communities, currentTags) = triple2
                MainPageScreenState.MainContent(
                    events = events,
                    comingEvents = comingEvents,
                    allTags = tags.tags,
                    currentTags = currentTags,
                    eventsByTags = eventsByTags,
                    communities = communities,
                    myCommunities = myCommunities
                )
            }.collect { newState ->
                _screenState.update { newState }
            }
        }
    }


    private fun updateTags(tags: List<String>) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            setTagsUseCase.execute(tags)
        }
    }

    fun selectedTags(tag: String) {
        _currentTagsFlow.update {
            if (it.contains(tag)) {
                it - tag
            } else {
                it + tag
            }
        }
        updateTags(_currentTagsFlow.value)
    }

    fun clearSelectedTags() {
        _currentTagsFlow.update {
            emptyList()
        }
        updateTags(_currentTagsFlow.value)
    }

    fun updateMyCommunityList(community: Community, communities: List<Community>) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            if (communities.any { it.id == community.id }) {
                deleteMyCommunityUseCase.execute(community.id)
            } else {
                addMyCommunityUseCase.execute(community)
            }
        }
    }

    fun isCommunityExists(community: Community, communities: List<Community>): Boolean {
        return communities.any { it.id == community.id }
    }
}
