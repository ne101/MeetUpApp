package com.example.wb_homework.di

import com.example.wb_homework.viewmodels.AllEventsViewModel
import com.example.wb_homework.viewmodels.AuthCodeViewModel
import com.example.wb_homework.viewmodels.AuthPhoneViewModel
import com.example.wb_homework.viewmodels.CommunityDetailsViewModel
import com.example.wb_homework.viewmodels.CommunityViewModel
import com.example.wb_homework.viewmodels.CreateAccountViewModel
import com.example.wb_homework.viewmodels.EventDetailsViewModel
import com.example.wb_homework.viewmodels.MoreViewModel
import com.example.wb_homework.viewmodels.MyEventsViewModel
import com.example.wb_homework.viewmodels.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::AllEventsViewModel)
    viewModelOf(::AuthPhoneViewModel)
    viewModelOf(::AuthCodeViewModel)
    viewModel { (id: Int) ->
        CommunityDetailsViewModel(
            getCommunityUseCase = get(),
            communityId = id
        )
    }
    viewModelOf(::CommunityViewModel)
    viewModelOf(::CreateAccountViewModel)
    viewModel { (id: Int) ->
        EventDetailsViewModel(
            getEventUseCase = get(),
            eventId = id,
            getMyEventListUseCase = get(),
            addMyEventUseCase = get(),
            deleteMyEventUseCase = get()
        )
    }
    viewModelOf(::MoreViewModel)
    viewModelOf(::MyEventsViewModel)
    viewModelOf(::ProfileViewModel)

}