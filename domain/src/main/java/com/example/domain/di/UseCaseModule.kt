package com.example.domain.di

import com.example.domain.interactor.AddMyEventInteractor
import com.example.domain.interactor.DeleteMyEventInteractor
import com.example.domain.interactor.DeleteProfileInteractor
import com.example.domain.interactor.GetActiveEventListInteractor
import com.example.domain.interactor.GetAllEventListInteractor
import com.example.domain.interactor.GetCommunityInteractor
import com.example.domain.interactor.GetCommunityListInteractor
import com.example.domain.interactor.GetEventInteractor
import com.example.domain.interactor.GetEventListInteractor
import com.example.domain.interactor.GetMyEventInteractor
import com.example.domain.interactor.GetMyEventListInteractor
import com.example.domain.interactor.GetPassedEventListInteractor
import com.example.domain.interactor.GetPlannedEventListInteractor
import com.example.domain.interactor.GetProfileInteractor
import com.example.domain.interactor.SaveProfileInteractor
import com.example.domain.usecases.AddMyEventUseCase
import com.example.domain.usecases.DeleteMyEventUseCase
import com.example.domain.usecases.DeleteProfileUseCase
import com.example.domain.usecases.GetActiveEventListUseCase
import com.example.domain.usecases.GetAllEventListUseCase
import com.example.domain.usecases.GetCommunityListUseCase
import com.example.domain.usecases.GetCommunityUseCase
import com.example.domain.usecases.GetEventListUseCase
import com.example.domain.usecases.GetEventUseCase
import com.example.domain.usecases.GetMyEventListUseCase
import com.example.domain.usecases.GetMyEventUseCase
import com.example.domain.usecases.GetPassedEventListUseCase
import com.example.domain.usecases.GetPlannedEventListUseCase
import com.example.domain.usecases.GetProfileUseCase
import com.example.domain.usecases.SaveProfileUseCase
import org.koin.dsl.module

internal val useCasesModule = module {
    single<GetCommunityUseCase> { GetCommunityInteractor(repository = get()) }
    single<GetCommunityListUseCase> { GetCommunityListInteractor(repository = get()) }
    single<GetEventUseCase> { GetEventInteractor(repository = get()) }
    single<GetEventListUseCase> { GetEventListInteractor(repository = get()) }
    single<GetProfileUseCase> { GetProfileInteractor(repository = get()) }
    single<GetAllEventListUseCase> { GetAllEventListInteractor(repository = get()) }
    single<GetActiveEventListUseCase> { GetActiveEventListInteractor(repository = get()) }
    single<GetPlannedEventListUseCase> { GetPlannedEventListInteractor(repository = get()) }
    single<GetPassedEventListUseCase> { GetPassedEventListInteractor(repository = get()) }
    single<AddMyEventUseCase> { AddMyEventInteractor(repository = get()) }
    single<DeleteMyEventUseCase> { DeleteMyEventInteractor(repository = get()) }
    single<DeleteProfileUseCase> { DeleteProfileInteractor(repository = get()) }
    single<GetMyEventUseCase> { GetMyEventInteractor(repository = get()) }
    single<GetMyEventListUseCase> { GetMyEventListInteractor(repository = get()) }
    single<SaveProfileUseCase> { SaveProfileInteractor(repository = get()) }

}