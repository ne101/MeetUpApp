package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.tags_usecases.GetMyTagsUseCase
import com.example.domain.usecases.tags_usecases.GetTagsUseCase
import com.example.domain.usecases.tags_usecases.SetMyTagsUseCase
import com.example.wb_homework.ui.screen_state.InterestsScreenState
import com.example.wb_homework.ui.state.ButtonState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InterestsViewModel(
    private val getTagsUseCase: GetTagsUseCase,
    private val getMyTagsUseCase: GetMyTagsUseCase,
    private val setMyTagsUseCase: SetMyTagsUseCase,
) : BaseViewModel() {
    private val _screenState = MutableStateFlow<InterestsScreenState>(InterestsScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    private val getTagsFlow = getTagsUseCase.execute().stateInViewModelScope(null)
    private val getMyTagsFlow = getMyTagsUseCase.execute().stateInViewModelScope(null)

    private val currentTags = MutableStateFlow<List<String>>(emptyList())


    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _screenState.update { InterestsScreenState.Error(error.message ?: "Unknown error") }
    }

    init {
        fetchInitialData()

    }

    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val initialMyTags = getMyTagsFlow.filterNotNull().first()
            currentTags.update { initialMyTags.tags }
            combine(
                getTagsFlow.filterNotNull(),
                getMyTagsFlow.filterNotNull(),
                currentTags,
            ) { tags, myTags, currentTags ->
                InterestsScreenState.MainContent(
                    tags = tags.tags,
                    mainButtonState = if (this@InterestsViewModel.currentTags.value.isEmpty()) {
                        ButtonState.Disabled
                    } else {
                        ButtonState.Primary
                    },
                    myTags = myTags.tags,
                    currentTags = currentTags
                )
            }.collect { newState ->
                _screenState.update {
                    newState
                }
            }
        }
    }

    fun getScreenState() = screenState

    fun setTagsInDB(tags: List<String>) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            setMyTagsUseCase.execute(tags)
        }
    }

    fun updateTags(tag: String) {
        currentTags.update {
            if (it.contains(tag)) {
                it - tag
            } else {
                it + tag
            }
        }
    }
}