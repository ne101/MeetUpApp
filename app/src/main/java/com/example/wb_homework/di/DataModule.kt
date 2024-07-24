package com.example.wb_homework.di

import com.example.data.RepositoryImpl
import com.example.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> { RepositoryImpl() }
}