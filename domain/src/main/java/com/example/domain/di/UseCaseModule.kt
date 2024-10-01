package com.example.domain.di

import com.example.domain.interactor.community_interactors.AddMyCommunityInteractor
import com.example.domain.interactor.event_interactors.AddMyEventInteractor
import com.example.domain.interactor.community_interactors.DeleteAllCommunitiesInteractor
import com.example.domain.interactor.event_interactors.DeleteAllEventsInteractor
import com.example.domain.interactor.community_interactors.DeleteMyCommunityInteractor
import com.example.domain.interactor.community_interactors.FetchCommunityInteractor
import com.example.domain.interactor.community_interactors.FetchCommunityListInteractor
import com.example.domain.interactor.event_interactors.DeleteMyEventInteractor
import com.example.domain.interactor.profile_interactors.DeleteProfileInteractor
import com.example.domain.interactor.event_interactors.FetchEventInteractor
import com.example.domain.interactor.event_interactors.GetActiveEventListInteractor
import com.example.domain.interactor.event_interactors.GetAllEventListInteractor
import com.example.domain.interactor.event_interactors.GetComingEventListInteractor
import com.example.domain.interactor.community_interactors.GetCommunityInteractor
import com.example.domain.interactor.community_interactors.GetCommunityListInteractor
import com.example.domain.interactor.event_interactors.GetEventInteractor
import com.example.domain.interactor.event_interactors.GetEventListByTagsInteractor
import com.example.domain.interactor.event_interactors.GetEventListInteractor
import com.example.domain.interactor.event_interactors.GetCommunityEventsInteractor
import com.example.domain.interactor.community_interactors.GetMyCommunityInteractor
import com.example.domain.interactor.community_interactors.GetMyCommunityListInteractor
import com.example.domain.interactor.event_interactors.GetMyEventInteractor
import com.example.domain.interactor.event_interactors.GetMyEventListInteractor
import com.example.domain.interactor.tags_interactors.GetMyTagsInteractor
import com.example.domain.interactor.event_interactors.GetPassedEventListInteractor
import com.example.domain.interactor.person_interactors.GetPersonListInteractor
import com.example.domain.interactor.event_interactors.GetPlannedEventListInteractor
import com.example.domain.interactor.profile_interactors.GetProfileInteractor
import com.example.domain.interactor.event_interactors.GetTagsInteractor
import com.example.domain.interactor.community_interactors.IsCommunityExistsInteractor
import com.example.domain.interactor.event_interactors.FetchEventListInteractor
import com.example.domain.interactor.event_interactors.IsEventExistsInteractor
import com.example.domain.interactor.profile_interactors.IsProfileExistsInteractor
import com.example.domain.interactor.profile_interactors.SaveProfileInteractor
import com.example.domain.interactor.tags_interactors.SetMyTagsInteractor
import com.example.domain.interactor.event_interactors.SetFilterTagsInteractor
import com.example.domain.interactor.person_interactors.FetchPersonListInteractor
import com.example.domain.interactor.profile_interactors.UpdateProfileInteractor
import com.example.domain.usecases.community_usecases.AddMyCommunityUseCase
import com.example.domain.usecases.event_usecases.AddMyEventUseCase
import com.example.domain.usecases.community_usecases.DeleteAllCommunitiesUseCase
import com.example.domain.usecases.event_usecases.DeleteAllEventsUseCase
import com.example.domain.usecases.community_usecases.DeleteMyCommunityUseCase
import com.example.domain.usecases.community_usecases.FetchCommunityListUseCase
import com.example.domain.usecases.community_usecases.FetchCommunityUseCase
import com.example.domain.usecases.event_usecases.DeleteMyEventUseCase
import com.example.domain.usecases.profile_usecases.DeleteProfileUseCase
import com.example.domain.usecases.event_usecases.FetchEventUseCase
import com.example.domain.usecases.event_usecases.GetActiveEventListUseCase
import com.example.domain.usecases.event_usecases.GetAllEventListUseCase
import com.example.domain.usecases.event_usecases.GetComingEventListUseCase
import com.example.domain.usecases.community_usecases.GetCommunityListUseCase
import com.example.domain.usecases.community_usecases.GetCommunityUseCase
import com.example.domain.usecases.event_usecases.GetEventListByTagsUseCase
import com.example.domain.usecases.event_usecases.GetEventListUseCase
import com.example.domain.usecases.event_usecases.GetEventUseCase
import com.example.domain.usecases.event_usecases.GetCommunityEventsUseCase
import com.example.domain.usecases.community_usecases.GetMyCommunityListUseCase
import com.example.domain.usecases.community_usecases.GetMyCommunityUseCase
import com.example.domain.usecases.event_usecases.GetMyEventListUseCase
import com.example.domain.usecases.event_usecases.GetMyEventUseCase
import com.example.domain.usecases.tags_usecases.GetMyTagsUseCase
import com.example.domain.usecases.event_usecases.GetPassedEventListUseCase
import com.example.domain.usecases.person_usecases.GetPersonListUseCase
import com.example.domain.usecases.event_usecases.GetPlannedEventListUseCase
import com.example.domain.usecases.profile_usecases.GetProfileUseCase
import com.example.domain.usecases.tags_usecases.GetTagsUseCase
import com.example.domain.usecases.community_usecases.IsCommunityExistsUseCase
import com.example.domain.usecases.event_usecases.FetchEventListUseCase
import com.example.domain.usecases.event_usecases.IsEventExistsUseCase
import com.example.domain.usecases.person_usecases.FetchPersonListUseCase
import com.example.domain.usecases.profile_usecases.IsProfileExistsUseCase
import com.example.domain.usecases.profile_usecases.SaveProfileUseCase
import com.example.domain.usecases.tags_usecases.SetMyTagsUseCase
import com.example.domain.usecases.tags_usecases.SetFilterTagsUseCase
import com.example.domain.usecases.profile_usecases.UpdateProfileUseCase
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

    single<GetEventListByTagsUseCase> { GetEventListByTagsInteractor(repository = get()) }
    single<GetComingEventListUseCase> { GetComingEventListInteractor(repository = get()) }
    single<GetTagsUseCase> { GetTagsInteractor(repository = get()) }
    single<SetFilterTagsUseCase> { SetFilterTagsInteractor(repository = get()) }
    single<GetCommunityEventsUseCase> { GetCommunityEventsInteractor(repository = get()) }
    single<GetPersonListUseCase> { GetPersonListInteractor(repository = get()) }
    single<GetMyTagsUseCase> { GetMyTagsInteractor(repository = get()) }
    single<SetMyTagsUseCase> { SetMyTagsInteractor(repository = get()) }
    single<GetMyCommunityUseCase> { GetMyCommunityInteractor(repository = get()) }
    single<GetMyCommunityListUseCase> { GetMyCommunityListInteractor(repository = get()) }
    single<AddMyCommunityUseCase> { AddMyCommunityInteractor(repository = get()) }
    single<DeleteMyCommunityUseCase> { DeleteMyCommunityInteractor(repository = get()) }
    single<IsCommunityExistsUseCase> { IsCommunityExistsInteractor(repository = get()) }
    single<IsEventExistsUseCase> { IsEventExistsInteractor(repository = get()) }
    single<UpdateProfileUseCase> { UpdateProfileInteractor(repository = get()) }
    single<IsProfileExistsUseCase> { IsProfileExistsInteractor(repository = get()) }
    single<DeleteAllEventsUseCase> { DeleteAllEventsInteractor(repository = get()) }
    single<DeleteAllCommunitiesUseCase> { DeleteAllCommunitiesInteractor(repository = get()) }
    single<FetchEventUseCase> { FetchEventInteractor(repository = get()) }
    single<FetchCommunityUseCase> {FetchCommunityInteractor(repository = get())}
    single<FetchEventListUseCase> { FetchEventListInteractor(repository = get()) }
    single<FetchCommunityListUseCase> { FetchCommunityListInteractor(repository = get()) }
    single<FetchPersonListUseCase> { FetchPersonListInteractor(repository = get()) }

}