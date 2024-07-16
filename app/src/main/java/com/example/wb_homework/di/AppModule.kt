package com.example.wb_homework.di

import com.example.wb_homework.ui.screens.CommunityDetails
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
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AllEventsViewModel(get())
    }
    viewModel {
       AuthCodeViewModel()
    }
    viewModel {
        AuthPhoneViewModel()
    }
    viewModel {
        CommunityDetailsViewModel(get())
    }
    viewModel {
        CommunityViewModel(get())
    }
    viewModel {
        CreateAccountViewModel()
    }
    viewModel {
        EventDetailsViewModel(get())
    }
    viewModel {
        MoreViewModel(get())
    }
    viewModel {
        MyEventsViewModel(get())
    }
    viewModel {
        ProfileViewModel(get())
    }
}