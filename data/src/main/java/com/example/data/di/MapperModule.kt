package com.example.data.di

import com.example.data.mapper.Mapper
import org.koin.dsl.module

internal val mapperModule = module {
    single { Mapper() }
}
