package com.example.wb_homework.di

import com.example.wb_homework.viewmodels.CommunityViewModel
import com.example.wb_homework.viewmodels.EventViewModel
import com.example.wb_homework.viewmodels.MainPageViewModel
import com.example.wb_homework.viewmodels.PersonViewModel
import com.example.wb_homework.viewmodels.InterestsViewModel
import com.example.wb_homework.viewmodels.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::MainPageViewModel)
    viewModel { (eventId: Int, communityId: Int) ->
        EventViewModel(
            getEventsByCommunityUseCase = get(),
            getCommunityUseCase = get(),
            getEventUseCase = get(),
            addMyEventUseCase = get(),
            deleteMyEventUseCase = get(),
            isEventExistsUseCase = get(),
            fetchEventUseCase = get(),
            eventId = eventId,
            communityId = communityId,
            fetchCommunityUseCase = get(),
            fetchEventListUseCase = get()
        )
    }
    viewModel { (communityId: Int) ->
        CommunityViewModel(
            getCommunityUseCase = get(),
            getCommunityEventsUseCase = get(),
            isCommunityExistsUseCase = get(),
            addMyCommunityUseCase = get(),
            deleteMyCommunityUseCase = get(),
            communityId = communityId,
            fetchCommunityUseCase = get()
        )
    }

    viewModel { (eventId: Int) ->
        PersonViewModel(
            getPersonListUseCase = get(),
            eventId = eventId,
            fetchPersonListUseCase = get()
        )
    }
    viewModelOf(::InterestsViewModel)
    viewModelOf(::ProfileViewModel)
}