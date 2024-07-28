package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetCommunityListUseCase
import com.example.wb_homework.screen_states.CommunityScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CommunityViewModel(
    private val getCommunityListUseCase: GetCommunityListUseCase,
) : ViewModel() {
    private val _screenState = getCommunityListUseCase.execute().map {
        CommunityScreenState.CommunityList(it)
    }
    private val screenState = _screenState



    fun getScreenState(): Flow<CommunityScreenState> {
        return screenState
    }

}