package com.example.data.di

import com.example.data.repository_impl.CommunityRepositoryImpl
import com.example.data.repository_impl.EventRepositoryImpl
import com.example.data.repository_impl.PersonRepositoryImpl
import com.example.data.repository_impl.ProfileRepositoryImpl
import com.example.data.repository_impl.TagsRepositoryImpl
import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.EventRepository
import com.example.domain.repository.PersonRepository
import com.example.domain.repository.ProfileRepository
import com.example.domain.repository.TagsRepository
import org.koin.dsl.module

internal val repositoryImplModule = module {
    single<PersonRepository> { PersonRepositoryImpl(mockData = get())}
    single<EventRepository> {EventRepositoryImpl(eventDao = get(), mockData = get(), mapper = get())}
    single<CommunityRepository> {CommunityRepositoryImpl(communityDao = get(), mockData = get(), mapper = get())}
    single<ProfileRepository> { ProfileRepositoryImpl(profileDao = get(), mapper = get()) }
    single<TagsRepository> {TagsRepositoryImpl(tagsDao = get(), mapper = get())}
}