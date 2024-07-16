package com.example.wb_homework.di

import com.example.wb_homework.data.RepositoryImpl
import com.example.wb_homework.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> { RepositoryImpl() }
}