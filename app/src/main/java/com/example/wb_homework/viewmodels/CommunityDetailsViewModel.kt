package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetCommunityUseCase
import com.example.wb_homework.screen_states.CommunityDetailsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CommunityDetailsViewModel(
    private val getCommunityUseCase: GetCommunityUseCase
) : ViewModel() {
    private val _screenState = getCommunityUseCase.execute().map {
        CommunityDetailsScreenState.CommunityDetails(it)
    }
    private val screenState = _screenState


    fun getScreenState(): Flow<CommunityDetailsScreenState> {
        return screenState
    }


}