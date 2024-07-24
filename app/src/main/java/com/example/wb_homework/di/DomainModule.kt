package com.example.wb_homework.di

import com.example.domain.usecases.GetCommunityListUseCase
import com.example.domain.usecases.GetCommunityUseCase
import com.example.domain.usecases.GetEventListUseCase
import com.example.domain.usecases.GetEventUseCase
import com.example.domain.usecases.GetProfileUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCommunityUseCase(repository = get()) }
    factory { GetCommunityListUseCase(repository = get()) }
    factory { GetEventUseCase(repository = get()) }
    factory { GetEventListUseCase(repository = get()) }
    factory { GetProfileUseCase(repository = get()) }

}