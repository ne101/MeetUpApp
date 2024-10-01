package com.example.data.di

import com.example.data.local_data_base.mock.MockData
import org.koin.dsl.module

internal val mockModule = module {
    single { MockData() }
}