package com.example.data.di

import com.example.data.repository_impl.RepositoryImpl
import com.example.domain.repository.Repository
import org.koin.dsl.module

internal val repositoryImplModule = module {
    single<Repository> { RepositoryImpl(mapper = get(), profileDao = get()) }
}