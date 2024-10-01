package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.person_usecases.FetchPersonListUseCase
import com.example.domain.usecases.person_usecases.GetPersonListUseCase
import com.example.wb_homework.ui.screen_state.PersonScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonViewModel(
    private val getPersonListUseCase: GetPersonListUseCase,
    private val fetchPersonListUseCase: FetchPersonListUseCase,
    private val eventId: Int
) : BaseViewModel() {
    private val _screenState = MutableStateFlow<PersonScreenState>(PersonScreenState.Initial)
    private val screenState = _screenState.asStateFlow()
    private val exceptionHandler = CoroutineExceptionHandler { _, message ->
        _screenState.update {
            PersonScreenState.Error(message.message ?: "Unknown error")
        }
    }

    fun getScreenState() = screenState

    init {
        fetchInitialData()
    }
    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchPersonListUseCase.execute(eventId)
            getPersonListUseCase.execute().map {
                PersonScreenState.MainContent(it)
            }.collect { newState ->
                _screenState.update {
                    newState
                }
            }
        }
    }
}